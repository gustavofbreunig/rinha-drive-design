package com.rinha.rinhadrivedesign.domain.context.extrato;

import java.time.Instant;
import java.util.List;

import com.rinha.rinhadrivedesign.domain.context.Cliente;
import com.rinha.rinhadrivedesign.domain.context.Transacao;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
public class Extrato {
    private Saldo saldo;
    private List<ExtratoTransacao> ultimas_transacoes;

    public static Extrato montaExtrato(Cliente cliente, List<Transacao> ultimas_transacoes) {

        return Extrato
                    .builder()
                    .saldo(new Saldo(cliente.getSaldo(), Instant.now(), cliente.getLimite()))
                    .ultimas_transacoes(ultimas_transacoes
                                            .stream()
                                            .map(transacao -> new ExtratoTransacao(transacao.getValor(), 
                                                                    transacao.getTipo().getTipo(), 
                                                                    transacao.getDescricao(), 
                                                                    transacao.getRealizadaEm()))
                                            .toList())
                    .build();
    }
}
