package com.rinha.rinhadrivedesign.domain.context;

import java.util.Date;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Transacao {
    private int id;
    private Cliente cliente;
    private int valor;
    private String tipo;
    private String descricao;
    private Date realizadaEm;
}
