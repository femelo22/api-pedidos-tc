package com.br.tc.adapters.dtos.order;

public record OrderCheckoutResponseDTO(
        String message,
        OrderResponseDTO order) {

}
