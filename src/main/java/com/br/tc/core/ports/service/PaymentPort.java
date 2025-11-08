package com.br.tc.core.ports.service;

import com.br.tc.adapters.dtos.order.OrderPayment;
import com.br.tc.core.model.Payment;

public interface PaymentPort {
    Payment updatePayment(Payment payment);
    void gerarPagamento(OrderPayment newPayment);
}
