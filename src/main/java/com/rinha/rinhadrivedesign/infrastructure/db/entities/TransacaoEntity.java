package com.rinha.rinhadrivedesign.infrastructure.db.entities;

import java.time.Instant;

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
    private Instant realizadaEm;

    @ManyToOne(fetch = FetchType.EAGER)
    private ClienteEntity cliente;

    public TransacaoEntity(int id) {
        this.id = id;
    }
}
