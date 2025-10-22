package com.br.tc.adapters.dtos.order;

import com.fastfood.api.adapters.dtos.client.ClientResponseDTO;
import com.fastfood.api.core.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponseDTO(
        Long id,
        ClientResponseDTO client,
        String cpf,
        OrderStatus status,
        BigDecimal totalPrice,
        LocalDateTime date,
        PaymentResponseDTO payment,
        List<OrderItemResponseDTO> items) {
}
