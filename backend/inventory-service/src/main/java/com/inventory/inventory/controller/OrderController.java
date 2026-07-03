package com.inventory.inventory.controller;

import com.inventory.inventory.dto.OrderRequest;
import com.inventory.inventory.dto.OrderResponse;

import com.inventory.inventory.entity.Order;

import com.inventory.inventory.mapper.OrderMapper;

import com.inventory.inventory.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

        @Autowired
        private OrderService service;

        @Autowired
        private OrderMapper mapper;

        @PostMapping
        public OrderResponse create(
                        @Valid @RequestBody OrderRequest request) {

                Order order = service.create(
                                request);

                return mapper.toResponse(
                                order);
        }

        @GetMapping
        public List<OrderResponse> getAll() {

                return service.findAll()
                                .stream()
                                .map(
                                                mapper::toResponse)
                                .toList();
        }

        @GetMapping("/{id}")
        public OrderResponse getById(
                        @PathVariable Long id) {

                return mapper.toResponse(
                                service.findById(id));
        }

        @DeleteMapping("/{id}")
        public void delete(
                        @PathVariable Long id) {

                service.delete(id);
        }

        @PutMapping("/{id}")
        public OrderResponse update(
                        @PathVariable Long id,
                        @RequestBody OrderRequest request) {

                return mapper.toResponse(
                                service.update(
                                                id,
                                                request));
        }
}