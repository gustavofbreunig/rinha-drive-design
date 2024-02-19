package com.rinha.rinhadrivedesign.domain.context.extrato;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public record Saldo(int total, @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ") Date data_extrato, int limite) {};