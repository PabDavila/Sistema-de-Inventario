package com.inventory.inventory.controller;

import com.inventory.inventory.dto.ProductRequest;
import com.inventory.inventory.dto.ProductResponse;
import com.inventory.inventory.entity.Product;
import com.inventory.inventory.mapper.ProductMapper;
import com.inventory.inventory.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import jakarta.validation.Valid;

@Tag(name = "Productos", description = "Gestión de productos del inventario")

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductMapper mapper;

    @Operation(summary = "Listar productos", description = "Obtiene todos los productos registrados")
    @GetMapping
    public List<ProductResponse> getAll() {

        return service.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Operation(summary = "Buscar producto por ID", description = "Obtiene un producto específico mediante su identificador")

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {

        Product product = service.findById(id);

        return mapper.toResponse(product);
    }

    @Operation(summary = "Crear producto", description = "Registra un nuevo producto")

    @PostMapping
    public ProductResponse create(
            @Valid @RequestBody ProductRequest request) {

        Product product = mapper.toEntity(request);

        Product saved = service.create(
                product,
                request.getCategoryId());

        return mapper.toResponse(saved);
    }

    @Operation(summary = "Actualizar producto", description = "Actualiza la información de un producto existente")

    @PutMapping("/{id}")
    public ProductResponse update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {

        Product product = mapper.toEntity(request);

        Product updated = service.update(
                id,
                product,
                request.getCategoryId());

        return mapper.toResponse(updated);
    }

    @Operation(summary = "Eliminar producto", description = "Elimina un producto del inventario")

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        service.delete(id);
    }

    @Operation(summary = "Buscar productos", description = "Busca productos por coincidencia parcial del nombre")

    @GetMapping("/search")
    public List<ProductResponse> search(
            @RequestParam String name) {

        return service.searchByName(name)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}