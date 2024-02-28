package com.rinha.rinhadrivedesign.domain.context;

import lombok.*;

@ToString
@Getter
@Setter
public class Cliente {
    private int id;

    private int saldo;

    private int limite;

    protected void deposito(int valor) {
        this.saldo += valor;
    }

    protected void retirada(int valor) {
        this.saldo -= valor;          
    }

    protected boolean estouraLimite(int valor) {
        return (this.saldo - valor) < (limite * -1);
    }

}
