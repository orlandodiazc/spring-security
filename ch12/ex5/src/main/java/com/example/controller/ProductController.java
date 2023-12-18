package com.example.controller;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products/{text}")
    public List<Product> findProductsContaining(@PathVariable String text) {
        return productRepository.findProductByNameContains(text);
    }
}