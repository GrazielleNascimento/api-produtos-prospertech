package com.prospertech.apirestprodutos.service;

import com.prospertech.apirestprodutos.entities.Product;
import com.prospertech.apirestprodutos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }

    public Product create(Product product) {
        Product productCreated = productRepository.save(product);
        return productCreated;
    }

    public Product update(Long id, Product product) {
        Product productUpdated = productRepository.findById(id).orElse(null);
        if (product != null) {
            productUpdated.setId(product.getId());
            productUpdated.setName(product.getName());
            productUpdated.setPrice(product.getPrice());
            productUpdated.setDescription(product.getDescription());
            productUpdated = productRepository.save(productUpdated);
        }
        return productUpdated;
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
