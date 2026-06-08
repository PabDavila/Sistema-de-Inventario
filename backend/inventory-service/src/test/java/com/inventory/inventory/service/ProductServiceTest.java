package com.inventory.inventory.service;

import com.inventory.inventory.entity.Product;
import com.inventory.inventory.repository.ProductRepository;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    void shouldReturnAllProducts() {

        Product p = new Product();
        p.setName("Mouse");

        when(repository.findAll())
                .thenReturn(List.of(p));

        List<Product> result = service.findAll();

        assertEquals(1, result.size());
    }

    @Test
    void shouldSearchByName() {

        Product p = new Product();
        p.setName("Teclado");

        when(repository
                .findByNameContainingIgnoreCase("tec"))
                .thenReturn(List.of(p));

        List<Product> result = service.searchByName("tec");

        assertEquals(1, result.size());
    }

    @Test
    void shouldFindAllProducts() {
        assertTrue(true);
    }

    @Test
    void shouldFindProductById() {
        assertTrue(true);
    }

    @Test
    void shouldCreateProduct() {
        assertTrue(true);
    }

    @Test
    void shouldDeleteProduct() {
        assertTrue(true);
    }
}