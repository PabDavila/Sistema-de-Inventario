package com.inventory.inventory.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private LocalDateTime orderDate =
            LocalDateTime.now();

    private String status;

    private String observation;

    @ManyToOne
    @JoinColumn(
            name = "client_id"
    )
    private Client client;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public LocalDateTime getOrderDate() {

        return orderDate;
    }

    public void setOrderDate(
            LocalDateTime orderDate
    ) {

        this.orderDate = orderDate;
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

    public Client getClient() {

        return client;
    }

    public void setClient(
            Client client
    ) {

        this.client = client;
    }
}