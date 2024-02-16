package com.rinha.rinhadrivedesign.domain.dto;

import com.rinha.rinhadrivedesign.domain.context.Cliente;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExtratoRequest {
    private Cliente cliente;
}
