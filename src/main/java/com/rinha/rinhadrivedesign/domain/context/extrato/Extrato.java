package com.rinha.rinhadrivedesign.domain.context.extrato;

import java.util.Date;
import java.util.List;

import com.rinha.rinhadrivedesign.domain.dto.ExtratoRequest;

import lombok.*;

@Setter
@Getter
@ToString
public class Extrato {
    private Saldo saldo;
    private List<ExtratoTransacao> ultimas_transacoes;

    public static Extrato montaExtrato(ExtratoRequest request) {

        Extrato extrato = new Extrato();
        extrato.ultimas_transacoes = 
                request.getUltimas_transacoes()
                .stream()
                .map(transacao -> new ExtratoTransacao(transacao.getValor(), 
                                        transacao.getTipo().getTipo(), 
                                        transacao.getDescricao(), 
                                        transacao.getRealizadaEm()))
                .toList();

        extrato.saldo = new Saldo(request.getCliente().getSaldo(), new Date(), request.getCliente().getLimite());
        return extrato;
    }
}
