package com.rinha.rinhadrivedesign.domain.dto;

import java.util.List;

import com.rinha.rinhadrivedesign.domain.context.Cliente;
import com.rinha.rinhadrivedesign.domain.context.Transacao;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExtratoRequest {
    private Cliente cliente;
    private List<Transacao> ultimas_transacoes;
}
