package com.br.tc.core.model;

import com.br.tc.core.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private Long id;
    private Client client;
    private String cpf;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private LocalDateTime date;
    private Payment payment;
    private List<OrderItem> items;

    public Order(Long id, Client client, String cpf, OrderStatus status, BigDecimal totalPrice, LocalDateTime date, Payment payment, List<OrderItem> items) {
        this.id = id;
        this.client = client;
        this.cpf = cpf;
        this.status = status;
        this.totalPrice = totalPrice;
        this.date = date;
        this.payment = payment;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }


}
