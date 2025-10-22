package com.br.tc.adapters.dtos.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientRequestDTO(
        @NotBlank(message = "name should not be null or blank")
        String name,
        String cpf,
        @NotBlank(message = "Email should not be null or blank")
        @Email
        String email,
        String phone) {
}
