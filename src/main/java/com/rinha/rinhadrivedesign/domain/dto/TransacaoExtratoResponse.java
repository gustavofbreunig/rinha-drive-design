package com.rinha.rinhadrivedesign.domain.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public record TransacaoExtratoResponse(
    int valor, 
    String tipo, 
    String descricao, 
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ") 
    Date realizada_em) {};
