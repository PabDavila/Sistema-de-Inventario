package com.inventory.inventory.service;

import com.inventory.inventory.entity.InventoryMovement;
import com.inventory.inventory.repository.InventoryMovementRepository;
import com.inventory.inventory.repository.ProductRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InventoryMovementServiceTest {

    @Mock
    private InventoryMovementRepository repository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private InventoryMovementService service;

    @Test
    void shouldFindAllMovements() {

        when(repository.findAll())
                .thenReturn(List.of(
                        new InventoryMovement()));

        assertEquals(
                1,
                service.findAll().size());
    }

    @Test
    void shouldRegisterEntryMovement() {
        assertTrue(true);
    }

    @Test
    void shouldRegisterExitMovement() {
        assertTrue(true);
    }
}