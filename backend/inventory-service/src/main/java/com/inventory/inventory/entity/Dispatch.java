package com.inventory.inventory.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "dispatches")
public class Dispatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dispatchDate = LocalDateTime.now();

    @NotBlank
    private String status;

    @NotBlank
    private String deliveryAddress;

    @NotNull
    private Long deliveryUserId;

    @NotNull
    private Long operatorUserId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(
            LocalDateTime dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status) {
        this.status = status;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(
            String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(
            Long deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }

    public Long getOperatorUserId() {
        return operatorUserId;
    }

    public void setOperatorUserId(
            Long operatorUserId) {
        this.operatorUserId = operatorUserId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(
            Order order) {
        this.order = order;
    }
}