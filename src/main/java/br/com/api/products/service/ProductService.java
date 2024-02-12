package br.com.api.products.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.products.convert.ModelMapperConver;
import br.com.api.products.dto.ProductDTO;
import br.com.api.products.exceptions.FieldValidationException;
import br.com.api.products.exceptions.ResourceNotFoundException;
import br.com.api.products.model.ExceptionModel;
import br.com.api.products.model.ProductModel;
import br.com.api.products.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapperConver modelMapperConver;

    @Autowired
    private ExceptionModel exceptionModel;

    public ResponseEntity<?> findById(Long id) {
        try {
            Optional<ProductModel> productVar = productRepository.findById(id);
            ProductModel product = productVar.orElseThrow(() -> new ResourceNotFoundException("Product not found for ID: " + id));
    
            ProductDTO productDTO = modelMapperConver.parseObject(product, ProductDTO.class);
            return ResponseEntity.ok(productDTO);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND); 
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error"); 
        }
    }
    

    public ResponseEntity<?> findAll() {
        try {
            Iterable<ProductModel> productModels = productRepository.findAllOrderedById();
        List<ProductDTO> productDTOs = modelMapperConver.parseListObjects(
                StreamSupport.stream(productModels.spliterator(), false)
                        .collect(Collectors.toList()),
                ProductDTO.class);
                return ResponseEntity.ok(productDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public ResponseEntity<?> create(ProductDTO product) {
        try {
            validateProduct(product);
            var entity = modelMapperConver.parseObject(product, ProductModel.class);
            return new ResponseEntity<ProductDTO>(modelMapperConver.parseObject(productRepository.save(entity), ProductDTO.class), HttpStatus.CREATED);
        } catch (FieldValidationException ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
    
    private void validateProduct(ProductDTO product) throws FieldValidationException {
        if (product.getName().equals("") || product.getName().length() < 3) {
            throw new FieldValidationException("Product name is invalid!");
        } else if (product.getBrand().equals("") || product.getBrand().length() < 3) {
            throw new FieldValidationException("Product brand is invalid!");
        }
    }

    public ResponseEntity<?> update(Long id, ProductDTO product) {
        try {
            validateProduct(product);
    
            Optional<ProductModel> productVar = productRepository.findById(id);
            ProductModel existingProduct = productVar.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    
            existingProduct.setName(product.getName());
            existingProduct.setBrand(product.getBrand());
    
            var updatedEntity = productRepository.save(existingProduct);
            var updatedDto = modelMapperConver.parseObject(updatedEntity, ProductDTO.class);
            return new ResponseEntity<ProductDTO>(updatedDto, HttpStatus.OK);
        } catch (FieldValidationException ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    public ResponseEntity<?> delete(Long id){
        try {
            Optional<ProductModel> productVar = productRepository.findById(id);
            productVar.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

            productRepository.deleteById(id);

            exceptionModel.setMessage("success in removing the product");
            return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}
