package com.inventory.inventory.repository;

import com.inventory.inventory.entity.Dispatch;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatchRepository
        extends JpaRepository<Dispatch, Long> {
}