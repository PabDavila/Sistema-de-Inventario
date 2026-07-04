package com.inventory.inventory.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @NotNull
    private LocalDateTime deliveryDate;

    @NotBlank
    private String finalStatus;

    private String observation;

    @OneToOne
    @JoinColumn(
            name = "dispatch_id"
    )
    @NotNull
    private Dispatch dispatch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(
            LocalDateTime deliveryDate
    ) {
        this.deliveryDate = deliveryDate;
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

    public Dispatch getDispatch() {
        return dispatch;
    }

    public void setDispatch(
            Dispatch dispatch
    ) {
        this.dispatch = dispatch;
    }
}