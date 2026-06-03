package com.inventory.inventory.controller;

import com.inventory.inventory.dto.MovementRequest;
import com.inventory.inventory.dto.MovementResponse;

import com.inventory.inventory.entity.InventoryMovement;

import com.inventory.inventory.mapper.InventoryMovementMapper;

import com.inventory.inventory.service.InventoryMovementService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
public class InventoryMovementController {

    @Autowired
    private InventoryMovementService service;

    @Autowired
    private InventoryMovementMapper mapper;

    @PostMapping
    public MovementResponse registerMovement(
            @Valid
            @RequestBody MovementRequest request) {

        InventoryMovement movement =
                service.registerMovement(
                        request.getProductId(),
                        request.getType(),
                        request.getQuantity());

        return mapper.toResponse(movement);
    }

    @GetMapping
    public List<MovementResponse> getAll() {

        return service.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/product/{productId}")
    public List<MovementResponse> getByProduct(
            @PathVariable Long productId) {

        return service.findByProduct(productId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}