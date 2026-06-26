package com.inventory.inventory.dto;

public class DeliveryRequest {

    private Long dispatchId;

    private String finalStatus;

    private String observation;

    public Long getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(
            Long dispatchId
    ) {
        this.dispatchId = dispatchId;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(
            String finalStatus
    ) {
        this.finalStatus = finalStatus;
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