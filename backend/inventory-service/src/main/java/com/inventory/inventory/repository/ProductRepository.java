package com.inventory.inventory.repository;

import com.inventory.inventory.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
}