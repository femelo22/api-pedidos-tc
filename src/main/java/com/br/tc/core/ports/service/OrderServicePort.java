package com.br.tc.core.ports.service;

import com.br.tc.adapters.dtos.order.OrderFilter;
import com.br.tc.core.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderServicePort {
    Order createAndCheckout(Order order);

    Page<Order> findAllByFilter(OrderFilter filter, Pageable pageable);

}
