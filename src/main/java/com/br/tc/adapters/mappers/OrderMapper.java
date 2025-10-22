package com.br.tc.adapters.mappers;

import com.br.tc.adapters.driven.entities.OrderEntity;
import com.br.tc.adapters.driven.entities.OrderItemEntity;
import com.br.tc.adapters.driven.entities.PaymentEntity;
import com.br.tc.adapters.dtos.order.OrderCheckoutRequestDTO;
import com.br.tc.adapters.dtos.order.OrderItemCheckoutRequestDTO;
import com.br.tc.adapters.dtos.order.OrderResponseDTO;
import com.br.tc.core.model.Order;
import com.br.tc.core.model.OrderItem;
import com.br.tc.core.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;


@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class OrderMapper {

    //TODO: Mudar esse mapper.. MS de pedidos não vai mais no banco de dados de cliente diretamente
    @Mapping(target = "client", expression = "java(orderCheckoutRequestDTO.clientId() == null ? null : clientServicePort.findById(orderCheckoutRequestDTO.clientId()))")
    @Mapping(target = "items", source = "orderItems")
    public abstract Order orderCheckoutRequestDTOToOrder(OrderCheckoutRequestDTO orderCheckoutRequestDTO);

    public abstract OrderResponseDTO orderToOrderResponseDTO(Order order);

    public abstract List<OrderResponseDTO> ordersToOrderResponseDTOs(List<Order> orders);

    public abstract OrderEntity orderToOrderEntity(Order order);

    public abstract Order orderEntityToOrder(OrderEntity orderEntity);

    public abstract List<Order> orderEntitiesToOrders(List<OrderEntity> orderEntities);

    @Mapping(target = "product", expression = "java(orderItemCheckoutRequestDTO.productId() == null ? null : productServicePort.findById(orderItemCheckoutRequestDTO.productId()))")
    @Mapping(target = "unitPrice", expression = "java(orderItemCheckoutRequestDTO.productId() == null ? null : productServicePort.findById(orderItemCheckoutRequestDTO.productId()).getPrice())")
    public abstract OrderItem orderItemCheckoutRequestDTOToOrderItem(OrderItemCheckoutRequestDTO orderItemCheckoutRequestDTO);

    public abstract List<OrderItem> orderCheckoutRequestDTOsToOrderItems(List<OrderItemCheckoutRequestDTO> orderCheckoutRequestDTOs);

    @Mapping(target = "order", ignore = true)
    public abstract OrderItem orderItemEntityToOrderItem(OrderItemEntity orderItemEntity);

    @Mapping(target = "order", ignore = true)
    public abstract Payment paymentEntityToPayment(PaymentEntity paymentEntity);
}