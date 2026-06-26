package com.inventory.inventory.repository;

import com.inventory.inventory.entity.Delivery;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository
        extends JpaRepository<Delivery, Long> {
}