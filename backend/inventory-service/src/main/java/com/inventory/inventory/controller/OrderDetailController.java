package com.inventory.inventory.controller;

import com.inventory.inventory.dto.OrderDetailRequest;
import com.inventory.inventory.dto.OrderDetailResponse;

import com.inventory.inventory.mapper.OrderDetailMapper;

import com.inventory.inventory.service.OrderDetailService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-details")
public class OrderDetailController {

    @Autowired
    private OrderDetailService service;

    @Autowired
    private OrderDetailMapper mapper;

    @PostMapping
    public OrderDetailResponse create(
            @Valid
            @RequestBody
            OrderDetailRequest request
    ) {

        return mapper.toResponse(
                service.create(
                        request
                )
        );
    }

    @GetMapping("/order/{orderId}")
    public List<OrderDetailResponse> findByOrder(
            @PathVariable Long orderId
    ) {

        return service.findByOrder(
                        orderId
                )
                .stream()
                .map(
                        mapper::toResponse
                )
                .toList();
    }
}