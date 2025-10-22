package com.br.tc.core.model;

import java.math.BigDecimal;

public class OrderItem {

    private Long id;
    private Order order;
    private Product product;
    private Integer amount;
    private BigDecimal unitPrice;
    private String notes;

    public OrderItem(Long id, Order order, Product product, Integer amount, BigDecimal unitPrice, String notes) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
