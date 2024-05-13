package com.prospertech.apirestprodutos.controller;

import com.prospertech.apirestprodutos.entities.Product;
import com.prospertech.apirestprodutos.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/findall")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);

    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        if(product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        Product productCreated = productService.create(product);
        if(productCreated != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productCreated);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody  Product product) {
        Product productUpdated = productService.update(id, product);
        if(productUpdated != null) {
            return ResponseEntity.status(HttpStatus.OK).body(productUpdated);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Product product = productService.findById(id);
        if(product != null) {
            productService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

