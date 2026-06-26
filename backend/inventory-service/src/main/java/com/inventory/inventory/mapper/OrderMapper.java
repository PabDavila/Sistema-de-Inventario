package com.inventory.inventory.mapper;

import com.inventory.inventory.dto.OrderResponse;
import com.inventory.inventory.entity.Order;

import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderResponse toResponse(
            Order order
    ) {

        OrderResponse response =
                new OrderResponse();

        response.setId(
                order.getId()
        );

        response.setClientId(
                order.getClient().getId()
        );

        response.setStatus(
                order.getStatus()
        );

        response.setObservation(
                order.getObservation()
        );

        response.setOrderDate(
                order.getOrderDate()
        );

        return response;
    }
}