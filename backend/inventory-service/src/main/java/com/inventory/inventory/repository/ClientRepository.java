package com.inventory.inventory.repository;

import com.inventory.inventory.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository
        extends JpaRepository<Client, Long> {
}