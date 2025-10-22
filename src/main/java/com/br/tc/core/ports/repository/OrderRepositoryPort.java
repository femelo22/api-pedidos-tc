package com.br.tc.core.ports.repository;

import com.br.tc.adapters.dtos.order.OrderFilter;
import com.br.tc.core.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface OrderRepositoryPort {
    Order create(Order order);

    Page<Order> findAllByFilter(OrderFilter filter, Pageable pageable);
}
