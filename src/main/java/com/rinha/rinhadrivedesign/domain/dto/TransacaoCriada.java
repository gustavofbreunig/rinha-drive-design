package com.rinha.rinhadrivedesign.domain.dto;

import com.rinha.rinhadrivedesign.domain.context.Cliente;
import com.rinha.rinhadrivedesign.domain.context.Transacao;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
public class TransacaoCriada {
    private Cliente cliente;
    private Transacao transacao;
}
