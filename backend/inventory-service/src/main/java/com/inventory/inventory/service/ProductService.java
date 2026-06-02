package com.inventory.inventory.service;

import com.inventory.inventory.entity.Product;
import com.inventory.inventory.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product create(Product product) {
        return repository.save(product);
    }

    public Product update(Long id, Product product) {

        Product existing = repository.findById(id)
                .orElseThrow();

        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setStock(product.getStock());
        existing.setPrice(product.getPrice());
        existing.setCategory(product.getCategory());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Product> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}