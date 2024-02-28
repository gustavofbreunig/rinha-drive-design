package com.rinha.rinhadrivedesign.domain.errors;

public class TransacaoInvalida extends RuntimeException {
    public TransacaoInvalida(String message) {
        super(message);
    }
}
