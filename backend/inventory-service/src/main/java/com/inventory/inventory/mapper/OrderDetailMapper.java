package com.inventory.inventory.mapper;

import com.inventory.inventory.dto.OrderDetailResponse;
import com.inventory.inventory.entity.OrderDetail;

import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {

    public OrderDetailResponse toResponse(
            OrderDetail detail
    ) {

        OrderDetailResponse response =
                new OrderDetailResponse();

        response.setId(
                detail.getId()
        );

        response.setOrderId(
                detail.getOrder().getId()
        );

        response.setProductId(
                detail.getProduct().getId()
        );

        response.setProductName(
                detail.getProduct().getName()
        );

        response.setQuantity(
                detail.getQuantity()
        );

        response.setUnitPrice(
                detail.getUnitPrice()
        );

        return response;
    }
}