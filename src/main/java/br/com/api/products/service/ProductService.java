package br.com.api.products.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.products.convert.ModelMapperConver;
import br.com.api.products.dto.ProductDTO;
import br.com.api.products.model.ProductModel;
import br.com.api.products.repository.ProductRepository;
import jakarta.validation.Valid;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapperConver modelMapperConver;

    public Iterable<ProductDTO> findAll() {
        Iterable<ProductModel> productModels = productRepository.findAll();
        List<ProductDTO> productDTOs = modelMapperConver.parseListObjects(
                StreamSupport.stream(productModels.spliterator(), false)
                        .collect(Collectors.toList()),
                ProductDTO.class);
        return productDTOs;
    }

    public ResponseEntity<?> create(@Valid ProductDTO product) {
        var entity = modelMapperConver.parseObject(product, ProductModel.class);
        return new ResponseEntity<ProductDTO>(modelMapperConver.parseObject(productRepository.save(entity), ProductDTO.class), HttpStatus.CREATED);
    }
}
