package com.br.tc.core.model;

import com.br.tc.core.model.enums.PaymentStatus;
import com.br.tc.core.model.enums.PaymentType;

public class Payment {

    private Long id;
    private Order order;
    private PaymentType type;
    private PaymentStatus status;
    private String qrCode;

    public Payment(Long id, Order order, PaymentType type, PaymentStatus status,String qrCode) {
        this.id = id;
        this.order = order;
        this.type = type;
        this.status = status;
        this.qrCode = qrCode;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public PaymentType getType() {
        return type;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
