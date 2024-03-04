package com.rinha.rinhadrivedesign.domain.context.extrato;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ExtratoTransacao(
    int valor, 
    String tipo, 
    String descricao,
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Instant realizada_em) {};