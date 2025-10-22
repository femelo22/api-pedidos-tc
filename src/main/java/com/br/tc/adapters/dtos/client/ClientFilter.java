package com.br.tc.adapters.dtos.client;

public record ClientFilter(
        Long id,
        String name,
        String cpf,
        String email,
        String phone) {
}
