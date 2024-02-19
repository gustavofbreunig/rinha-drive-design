package com.rinha.rinhadrivedesign.domain.context;

import java.util.Date;

import com.rinha.rinhadrivedesign.domain.dto.TransacaoResponse;

import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Transacao {
    private int id;
    private Cliente cliente;
    private int valor;
    private String tipo;
    private String descricao;
    private Date realizadaEm;

    public static TransacaoResponse valida(Transacao transacao) {
        return new TransacaoResponse(1, 2);
    }
}
