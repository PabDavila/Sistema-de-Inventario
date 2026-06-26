package com.inventory.inventory.dto;

public class DispatchRequest {

    private Long orderId;

    private String status;

    private String deliveryAddress;

    private Long deliveryUserId;

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