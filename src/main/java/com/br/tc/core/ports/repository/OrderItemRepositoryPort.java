package com.br.tc.core.ports.repository;

import com.br.tc.core.model.OrderItem;

import java.util.List;

public interface OrderItemRepositoryPort {
    List<OrderItem> saveAll(List<OrderItem> orderItems);
}
