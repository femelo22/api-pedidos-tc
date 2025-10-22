package com.br.tc.adapters.dtos.order;

import com.fastfood.api.core.model.enums.PaymentStatus;
import com.fastfood.api.core.model.enums.PaymentType;

public record PaymentResponseDTO(
        Long id,
        PaymentType type,
        PaymentStatus status,
        String qrCode) {
}
