package com.inventory.inventory.controller;

import com.inventory.inventory.dto.CategoryRequest;
import com.inventory.inventory.dto.CategoryResponse;

import com.inventory.inventory.entity.Category;

import com.inventory.inventory.mapper.CategoryMapper;
import com.inventory.inventory.service.CategoryService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Categorías", description = "Administración de categorías")

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @Autowired
    private CategoryMapper mapper;

    @Operation(summary = "Listar categorías", description = "Obtiene todas las categorías registradas")

    @GetMapping
    public List<CategoryResponse> getAll() {

        return service.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Operation(summary = "Buscar categoría por ID", description = "Obtiene una categoría específica mediante su identificador")

    @GetMapping("/{id}")
    public CategoryResponse getById(
            @PathVariable Long id) {

        return mapper.toResponse(
                service.findById(id));
    }

    @Operation(summary = "Crear categoría", description = "Registra una nueva categoría")

    @PostMapping
    public CategoryResponse create(
            @Valid @RequestBody CategoryRequest request) {

        Category saved = service.create(
                mapper.toEntity(request));

        return mapper.toResponse(saved);
    }

    @Operation(summary = "Actualizar categoría", description = "Actualiza la información de una categoría existente")

    @PutMapping("/{id}")
    public CategoryResponse update(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequest request) {

        Category updated = service.update(
                id,
                mapper.toEntity(request));

        return mapper.toResponse(updated);
    }

    @Operation(summary = "Eliminar categoría", description = "Elimina una categoría del sistema")

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        service.delete(id);
    }
}