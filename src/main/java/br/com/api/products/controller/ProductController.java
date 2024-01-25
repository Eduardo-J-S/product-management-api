package br.com.api.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.dto.ProductDTO;
import br.com.api.products.service.ProductService;
import jakarta.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public Iterable<ProductDTO> findAll(){
        return productService.findAll();
    }

    @PostMapping("/products")
    public ResponseEntity<?> create(@Valid @RequestBody ProductDTO product, BindingResult result){
        return productService.create(product, result);
    }

}
