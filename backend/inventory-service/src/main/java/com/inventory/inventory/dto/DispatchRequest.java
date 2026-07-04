package com.inventory.inventory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DispatchRequest {

    @NotNull
    private Long orderId;

    @NotBlank
    private String status;

    @NotBlank
    private String deliveryAddress;

    @NotNull
    private Long deliveryUserId;

    @NotNull
    private Long operatorUserId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(
            Long orderId
    ) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status
    ) {
        this.status = status;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(
            String deliveryAddress
    ) {
        this.deliveryAddress = deliveryAddress;
    }

    public Long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(
            Long deliveryUserId
    ) {
        this.deliveryUserId = deliveryUserId;
    }

    public Long getOperatorUserId() {
        return operatorUserId;
    }

    public void setOperatorUserId(
            Long operatorUserId
    ) {
        this.operatorUserId = operatorUserId;
    }
}