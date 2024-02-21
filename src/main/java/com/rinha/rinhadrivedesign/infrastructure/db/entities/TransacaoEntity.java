package com.rinha.rinhadrivedesign.infrastructure.db.entities;

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import com.rinha.rinhadrivedesign.domain.context.TipoTransacao;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transacoes")
public class TransacaoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;   

    private int valor;

    private TipoTransacao tipo;
    
    private String descricao;

    @Column(name = "realizada_em")
    private Date realizadaEm;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;

    public TransacaoEntity(int id) {
        this.id = id;
    }
}
