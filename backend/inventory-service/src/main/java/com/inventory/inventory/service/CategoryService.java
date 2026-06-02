package com.inventory.inventory.service;

import com.inventory.inventory.entity.Category;
import com.inventory.inventory.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public Category create(Category category) {
        return repository.save(category);
    }

    public Category update(Long id, Category category) {

        Category existing =
                repository.findById(id)
                        .orElseThrow();

        existing.setName(category.getName());
        existing.setDescription(category.getDescription());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}