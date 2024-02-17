package com.rinha.rinhadrivedesign.domain.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rinha.rinhadrivedesign.domain.context.Transacao;
import com.rinha.rinhadrivedesign.domain.dto.ExtratoRequest;
import com.rinha.rinhadrivedesign.domain.dto.ExtratoResponse;
import com.rinha.rinhadrivedesign.domain.dto.SaldoResponse;
import com.rinha.rinhadrivedesign.domain.dto.TransacaoResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExtratoServiceAdapterImpl implements ExtratoServiceAdapter {

    @Override
    public ExtratoResponse montaExtrato(ExtratoRequest request) {

        SaldoResponse saldo = 
                new SaldoResponse(new Date(), 
                        request.getCliente().getLimite(), 
                        request.getCliente().getSaldo());

        List<TransacaoResponse> ultimas_transacoes = 
                request.getUltimas_transacoes()
                .stream()
                .map(transacao -> new TransacaoResponse(transacao.getValor(), 
                                        transacao.getTipo(), 
                                        transacao.getDescricao(), 
                                        transacao.getRealizadaEm()))
                .toList();

        return ExtratoResponse.builder()                
                .saldo(saldo)
                .ultimas_transacoes(ultimas_transacoes)
                .build();
    }
    
}
