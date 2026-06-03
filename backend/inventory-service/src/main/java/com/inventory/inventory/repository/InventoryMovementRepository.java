package com.inventory.inventory.repository;

import com.inventory.inventory.entity.InventoryMovement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryMovementRepository
        extends JpaRepository<InventoryMovement, Long> {

    List<InventoryMovement> findByProductId(Long productId);
}