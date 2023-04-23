package com.example.labpropuesto.models;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private Long id;
    private String customerName;
    private String customerEmail;
    private String status;
    private LocalDateTime creationTime;
    private LocalDateTime estimatedDeliveryTime;
    private List<Food> items;

    public Order(String customerName, String customerEmail, List<Food> items) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.items = items;
        this.status = "En proceso";
        this.creationTime = LocalDateTime.now();
        this.estimatedDeliveryTime = this.creationTime.plusMinutes(30);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(LocalDateTime estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public List<Food> getItems() {
        return items;
    }

    public void setItems(List<Food> items) {
        this.items = items;
    }
}