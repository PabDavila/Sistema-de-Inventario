package com.inventory.inventory.controller;

import com.inventory.inventory.dto.CategoryRequest;
import com.inventory.inventory.dto.CategoryResponse;

import com.inventory.inventory.entity.Category;

import com.inventory.inventory.mapper.CategoryMapper;
import com.inventory.inventory.service.CategoryService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @Autowired
    private CategoryMapper mapper;

    @GetMapping
    public List<CategoryResponse> getAll() {

        return service.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public CategoryResponse getById(
            @PathVariable Long id) {

        return mapper.toResponse(
                service.findById(id));
    }

    @PostMapping
    public CategoryResponse create(
            @Valid @RequestBody CategoryRequest request) {

        Category saved =
                service.create(
                        mapper.toEntity(request));

        return mapper.toResponse(saved);
    }

    @PutMapping("/{id}")
    public CategoryResponse update(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequest request) {

        Category updated =
                service.update(
                        id,
                        mapper.toEntity(request));

        return mapper.toResponse(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        service.delete(id);
    }
}