package com.inventory.inventory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderRequest {

    @NotNull
    private Long clientId;

    @NotBlank
    private String status;

    private String observation;

    public Long getClientId() {

        return clientId;
    }

    public void setClientId(
            Long clientId
    ) {

        this.clientId = clientId;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(
            String status
    ) {

        this.status = status;
    }

    public String getObservation() {

        return observation;
    }

    public void setObservation(
            String observation
    ) {

        this.observation = observation;
    }
}