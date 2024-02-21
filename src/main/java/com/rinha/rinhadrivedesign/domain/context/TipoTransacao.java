package com.rinha.rinhadrivedesign.domain.context;

import com.rinha.rinhadrivedesign.domain.error.LimiteExcedidoException;

public enum TipoTransacao {
    Credito("c") {
        @Override
        public void efetuaTransacao(Cliente cliente, int valor) {
             cliente.deposito(valor);  
        }
    }, 
    Debito("d") {
        @Override
        public void efetuaTransacao(Cliente cliente, int valor) throws LimiteExcedidoException {
            cliente.retirada(valor);
        }
    };

    private String tipo;

    public String getTipo() {
        return this.tipo;
    }

    private TipoTransacao(String tipo) {
        this.tipo = tipo;
    }

    public abstract void efetuaTransacao(Cliente cliente, int valor) throws LimiteExcedidoException;

    public static TipoTransacao fromChar(String tipoChar) {
        for (TipoTransacao tipo : TipoTransacao.values()) {
            if (tipo.getTipo().equals(tipoChar)) {
                return tipo;
            }
        }

        throw new RuntimeException("Tipo de transacao \"%s\" nao encontrado".formatted(tipoChar));
    }

}
