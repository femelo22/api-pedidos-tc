package com.br.tc.adapters.dtos.order;

import jakarta.validation.constraints.NotNull;

public record OrderItemCheckoutRequestDTO(
        @NotNull(message = "productId should not be null")
        Long productId,
        @NotNull(message = "amount should not be null")
        Integer amount,
        String notes) {
}
