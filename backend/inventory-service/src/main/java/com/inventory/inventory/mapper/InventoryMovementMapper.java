package com.inventory.inventory.mapper;

import com.inventory.inventory.dto.MovementResponse;
import com.inventory.inventory.entity.InventoryMovement;

import org.springframework.stereotype.Component;

@Component
public class InventoryMovementMapper {

        public MovementResponse toResponse(
                        InventoryMovement movement) {

                MovementResponse dto = new MovementResponse();

                dto.setId(
                                movement.getId());

                dto.setProductId(
                                movement.getProduct().getId());

                dto.setProductName(
                                movement.getProduct().getName());

                dto.setType(
                                movement.getType().name());

                dto.setQuantity(
                                movement.getQuantity());

                dto.setMovementDate(
                                movement.getMovementDate());

                dto.setStatus(
                                movement.getStatus().name());

                return dto;
        }
}