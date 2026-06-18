package com.inventory.inventory.service;

import com.inventory.inventory.entity.InventoryMovement;
import com.inventory.inventory.entity.Product;
import com.inventory.inventory.entity.MovementType;

import com.inventory.inventory.repository.InventoryMovementRepository;
import com.inventory.inventory.repository.ProductRepository;

import com.inventory.inventory.exception.ResourceNotFoundException;
import com.inventory.inventory.exception.InsufficientStockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryMovementService {

    @Autowired
    private InventoryMovementRepository movementRepository;

    @Autowired
    private ProductRepository productRepository;

    public InventoryMovement registerMovement(
            Long productId,
            String type,
            Integer quantity
    ) {

        Product product = productRepository
                .findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Producto no encontrado"
                        )
                );

        MovementType movementType =
                MovementType.valueOf(
                        type.toUpperCase()
                );

        if (movementType == MovementType.EXIT) {

            if (product.getStock() < quantity) {

                throw new InsufficientStockException(
                        "Stock insuficiente"
                );
            }

            product.setStock(
                    product.getStock() - quantity
            );

        } else {

            product.setStock(
                    product.getStock() + quantity
            );
        }

        productRepository.save(product);

        InventoryMovement movement =
                new InventoryMovement();

        movement.setProduct(product);

        movement.setType(
                movementType
        );

        movement.setQuantity(
                quantity
        );

        return movementRepository.save(
                movement
        );
    }

    public List<InventoryMovement> findAll() {

        return movementRepository.findAll();
    }

    public List<InventoryMovement> findByProduct(
            Long productId
    ) {

        return movementRepository.findByProductId(
                productId
        );
    }
}