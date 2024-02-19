package com.rinha.rinhadrivedesign.domain.context.extrato;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ExtratoTransacao(
    int valor, 
    String tipo, 
    String descricao, 
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ") 
    Date realizada_em) {};