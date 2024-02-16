package com.rinha.rinhadrivedesign.domain.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaldoResponse {
    
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date data_extrato;

    private int total;

    private int limite;

}
