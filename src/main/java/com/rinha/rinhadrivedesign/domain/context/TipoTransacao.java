package com.rinha.rinhadrivedesign.domain.context;

import java.util.Set;

import com.rinha.rinhadrivedesign.domain.errors.TipoTransacaoInvalido;

public enum TipoTransacao {
    Credito("c", new DepositoStrategy()),
    Debito("d", new RetiradaStrategy());

    private String tipo;

    public String getTipo() {
        return this.tipo;
    }

    private TransacaoStrategy transacaoStrategy;

    public TransacaoStrategy getTransacaoStrategy() {
        return this.transacaoStrategy;
    }

    private TipoTransacao(String tipo, TransacaoStrategy strategy) {
        this.tipo = tipo;
        this.transacaoStrategy = strategy;
    }

    public static void valida(String tipo) {
        if (Set.of(TipoTransacao.values()).stream().filter(t -> t.getTipo().equals(tipo)).count() == 0) {
            throw new TipoTransacaoInvalido("Tipo de transacao \"%s\" nao encontrado".formatted(tipo));
        }
    }

    public static TipoTransacao fromString(String tipo) throws TipoTransacaoInvalido {
        //conversor de tipo de transação String para um tipo concreto
        //validação para jamais estar em um tipo inválido

        TipoTransacao.valida(tipo);
        
        for (TipoTransacao tipoConcreto : TipoTransacao.values()) {
            if (tipoConcreto.getTipo().equals(tipo)) {
                return tipoConcreto;
            }
        }

        throw new TipoTransacaoInvalido("tipo nao informado");
    }

}
