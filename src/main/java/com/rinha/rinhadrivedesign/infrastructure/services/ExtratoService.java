package com.rinha.rinhadrivedesign.infrastructure.services;

import com.rinha.rinhadrivedesign.domain.dto.ExtratoResponse;
import com.rinha.rinhadrivedesign.infrastructure.error.NotFoundException;

public interface ExtratoService {

    ExtratoResponse obtemExtrato(int ClienteId) throws NotFoundException;
    
}
