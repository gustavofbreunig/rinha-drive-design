package com.rinha.rinhadrivedesign.infrastructure.db.entities;

import java.util.List;

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
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int saldo;

    private int limite;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<TransacaoEntity> transacoes;

    public ClienteEntity(int id) {
        this.id = id;
    }

}
