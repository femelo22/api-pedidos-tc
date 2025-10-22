package com.br.tc.adapters.dtos.order;

import com.fastfood.api.adapters.dtos.product.ProductResponseDTO;

import java.math.BigDecimal;

public record OrderItemResponseDTO(
        Long id,
        ProductResponseDTO product,
        Integer amount,
        BigDecimal unitPrice,
        String notes) {
}
