package br.com.api.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.dto.ProductDTO;
import br.com.api.products.service.ProductService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {        
        return productService.findById(id);
    }

    @GetMapping("/products")
    public ResponseEntity<?> findAll(){
        return productService.findAll();
    }

    @PostMapping("/products")
    public ResponseEntity<?> create(@RequestBody ProductDTO pDto){
        return productService.create(pDto);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO pDto) {        
        return productService.update(id, pDto);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return productService.delete(id);
    }
}