package com.rinha.rinhadrivedesign.infrastructure.services;

import com.rinha.rinhadrivedesign.domain.context.extrato.Extrato;
import com.rinha.rinhadrivedesign.infrastructure.error.NotFoundException;

public interface ExtratoService {
    Extrato obtemExtrato(int ClienteId) throws NotFoundException;    
}
