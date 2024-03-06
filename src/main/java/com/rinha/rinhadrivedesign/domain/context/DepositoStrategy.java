package com.rinha.rinhadrivedesign.domain.context;

public class DepositoStrategy implements TransacaoStrategy {

    @Override
    public void efetuaTransacao(Cliente cliente, int valor) {        
        cliente.deposito(valor);
    }

    
}
