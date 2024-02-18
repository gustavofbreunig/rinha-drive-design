package com.rinha.rinhadrivedesign.interfaces.rest.controller;

import org.springframework.web.bind.annotation.*;

import com.rinha.rinhadrivedesign.domain.dto.ExtratoResponse;
import com.rinha.rinhadrivedesign.infrastructure.error.NotFoundException;
import com.rinha.rinhadrivedesign.infrastructure.services.ExtratoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClienteController {

    private final ExtratoService extratoService;

    @GetMapping(value="/clientes/{ClienteId}/extrato")
    public ExtratoResponse extrato(@PathVariable Integer ClienteId) throws NotFoundException{        
        ExtratoResponse response = extratoService.obtemExtrato(ClienteId);

        return response;
    }

    @PostMapping(value="/clientes/{ClienteId}/transacoes")
    public String transacao(@PathVariable Integer ClienteId) {        
        return "teste";
    }
}
