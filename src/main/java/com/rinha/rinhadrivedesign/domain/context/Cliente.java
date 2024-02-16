package com.rinha.rinhadrivedesign.domain.context;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Cliente {
    private int id;

    private int saldo;

    private int limite;
}
