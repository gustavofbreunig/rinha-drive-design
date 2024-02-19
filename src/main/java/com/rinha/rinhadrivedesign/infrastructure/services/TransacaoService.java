package com.rinha.rinhadrivedesign.infrastructure.services;

import com.rinha.rinhadrivedesign.domain.dto.TransacaoRequest;
import com.rinha.rinhadrivedesign.domain.dto.TransacaoResponse;

public interface TransacaoService {
    TransacaoResponse registraTransacao(int clienteId, TransacaoRequest transacaoRequest);
}
