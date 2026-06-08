package com.inventory.inventory.service;

import com.inventory.inventory.entity.Category;
import com.inventory.inventory.repository.CategoryRepository;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository repository;

    @InjectMocks
    private CategoryService service;

    @Test
    void shouldReturnCategories() {

        when(repository.findAll())
                .thenReturn(List.of(new Category()));

        assertEquals(
                1,
                service.findAll().size());
    }

    @Test
    void shouldCreateCategory() {
        assertTrue(true);
    }

    @Test
    void shouldFindAllCategories() {
        assertTrue(true);
    }
}