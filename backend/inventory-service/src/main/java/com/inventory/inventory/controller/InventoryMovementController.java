package com.inventory.inventory.controller;

import com.inventory.inventory.dto.MovementRequest;
import com.inventory.inventory.dto.MovementResponse;

import com.inventory.inventory.entity.InventoryMovement;

import com.inventory.inventory.mapper.InventoryMovementMapper;

import com.inventory.inventory.service.InventoryMovementService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Movimientos", description = "Kardex e historial de movimientos de inventario")

@RestController
@RequestMapping("/movements")
public class InventoryMovementController {

    @Autowired
    private InventoryMovementService service;

    @Autowired
    private InventoryMovementMapper mapper;

    @Operation(summary = "Registrar movimiento", description = "Registra una entrada o salida de inventario y actualiza el stock")

    @PostMapping
    public MovementResponse registerMovement(
            @Valid @RequestBody MovementRequest request) {

        InventoryMovement movement = service.registerMovement(
                request.getProductId(),
                request.getType(),
                request.getQuantity());

        return mapper.toResponse(movement);
    }

    @Operation(summary = "Listar movimientos", description = "Obtiene todos los movimientos de inventario registrados")

    @GetMapping
    public List<MovementResponse> getAll() {

        return service.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Operation(summary = "Movimientos por producto", description = "Obtiene el historial de movimientos de un producto específico")

    @GetMapping("/product/{productId}")
    public List<MovementResponse> getByProduct(
            @PathVariable Long productId) {

        return service.findByProduct(productId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}