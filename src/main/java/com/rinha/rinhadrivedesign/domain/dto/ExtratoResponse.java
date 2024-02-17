package com.rinha.rinhadrivedesign.domain.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExtratoResponse {

    private SaldoResponse saldo;
    private List<TransacaoResponse> ultimas_transacoes;

}

