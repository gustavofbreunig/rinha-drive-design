package com.rinha.rinhadrivedesign.domain.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public record SaldoResponse(@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ") Date data_extrato, int total, int limite) {};
