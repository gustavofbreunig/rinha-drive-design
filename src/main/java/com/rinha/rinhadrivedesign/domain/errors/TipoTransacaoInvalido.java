package com.rinha.rinhadrivedesign.domain.errors;


public class TipoTransacaoInvalido extends RuntimeException {
    public TipoTransacaoInvalido(String message){
        super(message);
    }
}
