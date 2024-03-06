package com.rinha.rinhadrivedesign.domain.context;

public class RetiradaStrategy implements TransacaoStrategy {

    @Override
    public void efetuaTransacao(Cliente cliente, int valor) {
        cliente.retirada(valor);
    }
    
}
