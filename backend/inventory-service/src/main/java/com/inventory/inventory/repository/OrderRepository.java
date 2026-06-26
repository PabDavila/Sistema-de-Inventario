package com.inventory.inventory.repository;

import com.inventory.inventory.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository
        extends JpaRepository<Order, Long> {
}