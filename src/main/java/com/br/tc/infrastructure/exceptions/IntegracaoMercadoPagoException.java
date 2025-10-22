package com.br.tc.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IntegracaoMercadoPagoException extends RuntimeException {

    public IntegracaoMercadoPagoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}