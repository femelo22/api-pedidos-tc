package com.br.tc.infrastructure.exceptions;

public record ErrorMessage(
        String path,
        int statusCode,
        String errorMessage
) {
}
