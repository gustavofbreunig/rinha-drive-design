package com.rinha.rinhadrivedesign.domain.context;

import java.util.Date;

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

    private TipoTransacao tipo;
    
    private String descricao;
    
    private Date realizadaEm;

    public Transacao(Cliente cliente, int valor, TipoTransacao tipo, String descricao)
    {
        this.cliente = cliente;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.realizadaEm = new Date();
    }
}
