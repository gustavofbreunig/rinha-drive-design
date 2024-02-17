package com.rinha.rinhadrivedesign.infrastructure.db.entities;

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

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
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private int id;   

    private int valor;
    private String tipo; //TODO: trocar para enum
    private String descricao;

    @Column(name = "realizada_em")
    private Date realizadaEm;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;

    public TransacaoEntity(int id) {
        this.id = id;
    }
}
