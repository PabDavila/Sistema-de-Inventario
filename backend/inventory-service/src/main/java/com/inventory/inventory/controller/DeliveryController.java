package com.inventory.inventory.controller;

import com.inventory.inventory.dto.DeliveryRequest;
import com.inventory.inventory.dto.DeliveryResponse;

import com.inventory.inventory.entity.Delivery;

import com.inventory.inventory.mapper.DeliveryMapper;

import com.inventory.inventory.service.DeliveryService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    @Autowired
    private DeliveryMapper mapper;

    @PostMapping
    public DeliveryResponse create(
            @RequestBody
            DeliveryRequest request
    ) {

        Delivery delivery =
                service.create(
                        request
                );

        return mapper.toResponse(
                delivery
        );
    }

    @GetMapping
    public List<DeliveryResponse> getAll() {

        return service.findAll()
                .stream()
                .map(
                        mapper::toResponse
                )
                .toList();
    }

    @GetMapping("/{id}")
    public DeliveryResponse getById(
            @PathVariable Long id
    ) {

        return mapper.toResponse(
                service.findById(id)
        );
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {

        service.delete(id);
    }
}