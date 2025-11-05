package com.br.tc.service;

import com.br.tc.adapters.dtos.order.OrderFilter;
import com.br.tc.core.model.Order;
import com.br.tc.core.model.enums.OrderStatus;
import com.br.tc.core.ports.repository.OrderRepositoryPort;
import com.br.tc.core.ports.service.OrderServicePort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImp implements OrderServicePort {


    @Autowired
    private OrderRepositoryPort orderRepository;

    @Transactional
    @Override
    public Order createAndCheckout(Order order) {
        BigDecimal totalPrice = order.getItems().stream()
                .map(i -> BigDecimal.valueOf(i.getAmount()).multiply(i.getUnitPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalPrice(totalPrice);
        order.setStatus(OrderStatus.RECEIVED);

        return orderRepository.create(order);
    }

    @Override
    public Page<Order> findAllByFilter(OrderFilter filter, Pageable pageable) {
        return orderRepository.findAllByFilter(filter, pageable);
    }


}
