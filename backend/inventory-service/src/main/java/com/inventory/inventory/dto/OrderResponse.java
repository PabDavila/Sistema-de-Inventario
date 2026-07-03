package com.inventory.inventory.dto;

import java.time.LocalDateTime;

public class OrderResponse {

    private Long id;

    private Long clientId;

    private String clientName;

    private String clientAddress;

    private String status;

    private String observation;

    private LocalDateTime orderDate;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getClientId() {

        return clientId;
    }

    public void setClientId(Long clientId) {

        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public String getObservation() {

        return observation;
    }

    public void setObservation(
            String observation) {

        this.observation = observation;
    }

    public LocalDateTime getOrderDate() {

        return orderDate;
    }

    public void setOrderDate(
            LocalDateTime orderDate) {

        this.orderDate = orderDate;
    }
}