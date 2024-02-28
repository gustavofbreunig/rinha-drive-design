package com.rinha.rinhadrivedesign.domain.context.extrato;

import java.time.Instant;

public record ExtratoTransacao(
    int valor, 
    String tipo, 
    String descricao,
    Instant realizada_em) {};