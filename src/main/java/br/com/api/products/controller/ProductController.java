package br.com.api.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.dto.ProductDTO;
import br.com.api.products.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public Iterable<ProductDTO> findAll(){
        return productService.findAll();
    }

    @PostMapping("/products")
    public ResponseEntity<?> create(@RequestBody ProductDTO product){
        return productService.create(product);
    }
}
