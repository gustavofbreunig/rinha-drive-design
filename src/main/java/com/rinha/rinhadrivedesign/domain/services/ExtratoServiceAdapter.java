package com.rinha.rinhadrivedesign.domain.services;

import com.rinha.rinhadrivedesign.domain.dto.ExtratoRequest;
import com.rinha.rinhadrivedesign.domain.dto.ExtratoResponse;

public interface ExtratoServiceAdapter {
    ExtratoResponse montaExtrato(ExtratoRequest request);
}
