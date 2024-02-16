package com.rinha.rinhadrivedesign.domain.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.rinha.rinhadrivedesign.domain.dto.ExtratoRequest;
import com.rinha.rinhadrivedesign.domain.dto.ExtratoResponse;
import com.rinha.rinhadrivedesign.domain.dto.SaldoResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExtratoServiceAdapterImpl implements ExtratoServiceAdapter {

    @Override
    public ExtratoResponse montaExtrato(ExtratoRequest request) {

        SaldoResponse saldo = SaldoResponse.builder()
            .data_extrato(new Date())
            .limite(request.getCliente().getLimite())
            .total(request.getCliente().getSaldo())
            .build();

        return ExtratoResponse.builder()                
                .saldo(saldo)
                .build();
    }
    
}
