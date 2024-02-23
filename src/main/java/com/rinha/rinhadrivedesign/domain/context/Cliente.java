package com.rinha.rinhadrivedesign.domain.context;

import com.rinha.rinhadrivedesign.domain.error.LimiteExcedidoException;

import lombok.*;

@Setter
@Getter
@ToString
public class Cliente {
    private int id;

    private int saldo;

    private int limite;

    public void deposito(int valor) {
        this.saldo += valor;
    }

    public void retirada(int valor) throws LimiteExcedidoException {
        this.saldo -= valor;
        if (this.saldo < (this.limite * -1)) {
            throw new LimiteExcedidoException("Limite excedido");
        }           
    }

    public Transacao Movimentacao(TipoTransacao tipo, int valor, String descricao) throws LimiteExcedidoException
    {
        if (valor < 0)
        {
            throw new LimiteExcedidoException("valor < 0");
        }

        if (descricao == null || descricao.isEmpty())
        {
            throw new LimiteExcedidoException("isEmpty");
        }

        if (descricao.length() > 10)
        {
            throw new LimiteExcedidoException("lenght > 10");
        }

        //faz a transação de acordo com a estratégia do tipo de transação
        tipo.efetuaTransacao(this, valor);
        return new Transacao(this, valor, tipo, descricao);            
    }
}
