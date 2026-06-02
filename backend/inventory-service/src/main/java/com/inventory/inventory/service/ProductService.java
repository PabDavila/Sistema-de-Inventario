package com.inventory.inventory.service;

import com.inventory.inventory.entity.Product;
import com.inventory.inventory.entity.Category;
import com.inventory.inventory.repository.CategoryRepository;
import com.inventory.inventory.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product create(Product product, Long categoryId) {

    Category category = categoryRepository
            .findById(categoryId)
            .orElseThrow();

    product.setCategory(category);

    return repository.save(product);
}

    public Product update(
        Long id,
        Product product,
        Long categoryId) {

    Product existing = repository.findById(id)
            .orElseThrow();

    Category category = categoryRepository
            .findById(categoryId)
            .orElseThrow();

    existing.setName(product.getName());
    existing.setDescription(product.getDescription());
    existing.setStock(product.getStock());
    existing.setPrice(product.getPrice());
    existing.setCategory(category);

    return repository.save(existing);
}

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Product> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

}