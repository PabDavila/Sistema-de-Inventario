package com.inventory.inventory.mapper;

import com.inventory.inventory.dto.DeliveryResponse;
import com.inventory.inventory.entity.Delivery;

import org.springframework.stereotype.Component;

@Component
public class DeliveryMapper {

    public DeliveryResponse toResponse(
            Delivery delivery
    ) {

        DeliveryResponse response =
                new DeliveryResponse();

        response.setId(
                delivery.getId()
        );

        response.setDispatchId(
                delivery.getDispatch().getId()
        );

        response.setFinalStatus(
                delivery.getFinalStatus()
        );

        response.setObservation(
                delivery.getObservation()
        );

        response.setDeliveryDate(
                delivery.getDeliveryDate()
        );

        return response;
    }
}