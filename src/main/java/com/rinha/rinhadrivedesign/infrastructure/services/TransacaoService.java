package com.rinha.rinhadrivedesign.infrastructure.services;

import com.rinha.rinhadrivedesign.domain.dto.TransacaoRequest;
import com.rinha.rinhadrivedesign.domain.dto.TransacaoResponse;
import com.rinha.rinhadrivedesign.infrastructure.error.NotFoundException;
import com.rinha.rinhadrivedesign.infrastructure.error.UnprocessableEntityException;

public interface TransacaoService {
    TransacaoResponse registraTransacao(int clienteId, TransacaoRequest transacaoRequest) throws NotFoundException, UnprocessableEntityException;
}
