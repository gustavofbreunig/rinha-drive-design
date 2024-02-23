package com.rinha.rinhadrivedesign.domain.context.extrato;

import java.util.Date;
import java.util.List;

import com.rinha.rinhadrivedesign.domain.context.Cliente;
import com.rinha.rinhadrivedesign.domain.context.Transacao;

import lombok.*;

@Setter
@Getter
@ToString
public class Extrato {
    private Saldo saldo;
    private List<ExtratoTransacao> ultimas_transacoes;

    public static Extrato montaExtrato(Cliente cliente, List<Transacao> ultimas_transacoes) {

        Extrato extrato = new Extrato();
        extrato.ultimas_transacoes = 
                ultimas_transacoes
                .stream()
                .map(transacao -> new ExtratoTransacao(transacao.getValor(), 
                                        transacao.getTipo().getTipo(), 
                                        transacao.getDescricao(), 
                                        transacao.getRealizadaEm()))
                .toList();

        extrato.saldo = new Saldo(cliente.getSaldo(), new Date(), cliente.getLimite());
        return extrato;
    }
}
