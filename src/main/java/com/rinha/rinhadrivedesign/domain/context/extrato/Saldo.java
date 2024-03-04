package com.rinha.rinhadrivedesign.domain.context.extrato;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public record Saldo(
    int total, 
    @JsonFormat(shape = JsonFormat.Shape.STRING) 
    Instant data_extrato, 
    int limite) 
    {};