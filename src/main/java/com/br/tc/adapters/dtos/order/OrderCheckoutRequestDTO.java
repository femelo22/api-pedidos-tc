package com.br.tc.adapters.dtos.order;

import com.br.tc.core.model.enums.PaymentType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderCheckoutRequestDTO(
        Long clientId,
        String cpf,
        @NotNull(message = "payment type should not be null")
        PaymentType paymentType,
        @NotEmpty(message = "items should not be empty.")
        List<@Valid OrderItemCheckoutRequestDTO> orderItems) {
}
