package com.rinha.rinhadrivedesign.domain.context;

public interface TransacaoStrategy {
    void efetuaTransacao(Cliente cliente, int valor);
}
