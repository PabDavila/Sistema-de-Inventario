package com.inventory.inventory.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "dispatches")
public class Dispatch {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private LocalDateTime dispatchDate =
            LocalDateTime.now();

    private String status;

    private String deliveryAddress;

    private Long deliveryUserId;

    private Long operatorUserId;

    @OneToOne
    @JoinColumn(
            name = "order_id"
    )
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
            LocalDateTime dispatchDate
    ) {
        this.dispatchDate = dispatchDate;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(
            Order order
    ) {
        this.order = order;
    }
}