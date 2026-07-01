package com.inventory.inventory.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory_movements")
public class InventoryMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MovementType type;

    private Integer quantity;

    private LocalDateTime movementDate;

    @Enumerated(EnumType.STRING)
    private MovementStatus status;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public InventoryMovement() {

        this.movementDate = LocalDateTime.now();

        this.status = MovementStatus.PENDING;

    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public MovementType getType() {

        return type;

    }

    public void setType(MovementType type) {

        this.type = type;

    }

    public Integer getQuantity() {

        return quantity;

    }

    public void setQuantity(Integer quantity) {

        this.quantity = quantity;

    }

    public LocalDateTime getMovementDate() {

        return movementDate;

    }

    public void setMovementDate(
            LocalDateTime movementDate) {

        this.movementDate = movementDate;

    }

    public Product getProduct() {

        return product;

    }

    public void setProduct(Product product) {

        this.product = product;

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public MovementStatus getStatus() {
        return status;
    }

    public void setStatus(MovementStatus status) {
        this.status = status;
    }

}