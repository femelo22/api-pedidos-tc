package com.br.tc.adapters.mappers;

import com.br.tc.adapters.driven.entities.OrderEntity;
import com.br.tc.adapters.dtos.order.OrderCheckoutRequestDTO;
import com.br.tc.adapters.dtos.order.OrderResponseDTO;
import com.br.tc.core.model.Order;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;


@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class OrderMapper {

    //TODO: Mudar esse mapper.. MS de pedidos não vai mais no banco de dados de cliente diretamente
//    @Mapping(target = "items", source = "orderItems")
//    public abstract Order orderCheckoutRequestDTOToOrder(OrderCheckoutRequestDTO orderCheckoutRequestDTO);


    @Mapping(target = "client", expression = "java(orderCheckoutRequestDTO.clientId() == null ? null : new Client(orderCheckoutRequestDTO.clientId()))")
    @Mapping(target = "items", source = "orderItems")
    @Mapping(target = "status", ignore = true) // será definido no serviço
    @Mapping(target = "totalPrice", ignore = true) // calcular depois
    @Mapping(target = "payment", ignore = true) // será tratado depois
    @Mapping(target = "date", ignore = true) // setar no serviço
    public abstract Order orderCheckoutRequestDTOToOrder(OrderCheckoutRequestDTO orderCheckoutRequestDTO);

    public abstract OrderResponseDTO orderToOrderResponseDTO(Order order);

    public abstract List<OrderResponseDTO> ordersToOrderResponseDTOs(List<Order> orders);

    public abstract OrderEntity orderToOrderEntity(Order order);

    public abstract Order orderEntityToOrder(OrderEntity orderEntity);

    public abstract List<Order> orderEntitiesToOrders(List<OrderEntity> orderEntities);
}