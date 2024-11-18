package com.example.MicroserviceStock.entity;

import jakarta.persistence.*;

@Entity
@Table(name="stock")
public class StockEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private long quantity;
    private String item;

    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
