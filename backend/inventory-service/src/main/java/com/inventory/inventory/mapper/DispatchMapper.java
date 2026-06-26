package com.inventory.inventory.mapper;

import com.inventory.inventory.dto.DispatchResponse;
import com.inventory.inventory.entity.Dispatch;

import org.springframework.stereotype.Component;

@Component
public class DispatchMapper {

    public DispatchResponse toResponse(
            Dispatch dispatch
    ) {

        DispatchResponse response =
                new DispatchResponse();

        response.setId(
                dispatch.getId()
        );

        response.setOrderId(
                dispatch.getOrder().getId()
        );

        response.setStatus(
                dispatch.getStatus()
        );

        response.setDeliveryAddress(
                dispatch.getDeliveryAddress()
        );

        response.setDeliveryUserId(
                dispatch.getDeliveryUserId()
        );

        response.setOperatorUserId(
                dispatch.getOperatorUserId()
        );

        response.setDispatchDate(
                dispatch.getDispatchDate()
        );

        return response;
    }
}