package com.inventory.inventory.repository;

import com.inventory.inventory.entity.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository
        extends JpaRepository<OrderDetail, Long> {

    List<OrderDetail> findByOrderId(
            Long orderId
    );
}