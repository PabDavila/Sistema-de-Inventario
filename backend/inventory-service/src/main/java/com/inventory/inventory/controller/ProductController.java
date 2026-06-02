package com.inventory.inventory.controller;

import com.inventory.inventory.dto.ProductRequest;
import com.inventory.inventory.dto.ProductResponse;
import com.inventory.inventory.entity.Product;
import com.inventory.inventory.mapper.ProductMapper;
import com.inventory.inventory.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductMapper mapper;

    @GetMapping
    public List<ProductResponse> getAll() {

        return service.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {

        Product product = service.findById(id);

        return mapper.toResponse(product);
    }

    @PostMapping
    public ProductResponse create(
            @Valid @RequestBody ProductRequest request) {

        Product product = mapper.toEntity(request);

        Product saved = service.create(
        product,
        request.getCategoryId()
);

        return mapper.toResponse(saved);
    }

    @PutMapping("/{id}")
    public ProductResponse update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {

        Product product = mapper.toEntity(request);

        Product updated = service.update(
        id,
        product,
        request.getCategoryId()
);

        return mapper.toResponse(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        service.delete(id);
    }

    @GetMapping("/search")
    public List<ProductResponse> search(
            @RequestParam String name) {

        return service.searchByName(name)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}