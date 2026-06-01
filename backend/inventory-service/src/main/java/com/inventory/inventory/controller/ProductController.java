package com.inventory.inventory.controller;

import com.inventory.inventory.dto.ProductDTO;
import com.inventory.inventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<ProductDTO> getProducts(
            Pageable pageable) {

        return productService.getProducts(pageable);
    }

    @PostMapping
    public ProductDTO createProduct(
            @Valid @RequestBody ProductDTO dto) {

        return productService.createProduct(dto);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductDTO dto) {

        return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(
            @PathVariable Long id) {

        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<ProductDTO> searchProducts(
            @RequestParam String name) {

        return productService.searchProducts(name);
    }

    @GetMapping("/admin-test")
    public String adminTest() {

        return "ADMIN ACCESS";
    }
}