package com.rinha.rinhadrivedesign.domain.dto;

import lombok.*;

@Setter
@Getter
@ToString
public class TransacaoRequest {
    private int valor;
    private String tipo;
    private String descricao;
}
