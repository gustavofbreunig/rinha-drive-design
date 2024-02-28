package com.rinha.rinhadrivedesign.interfaces.rest.controller;

import org.springframework.web.bind.annotation.*;

import com.rinha.rinhadrivedesign.domain.context.extrato.Extrato;
import com.rinha.rinhadrivedesign.domain.dto.TransacaoRequest;
import com.rinha.rinhadrivedesign.domain.dto.TransacaoResponse;
import com.rinha.rinhadrivedesign.infrastructure.error.NotFoundException;
import com.rinha.rinhadrivedesign.infrastructure.error.UnprocessableEntityException;
import com.rinha.rinhadrivedesign.infrastructure.services.ExtratoService;
import com.rinha.rinhadrivedesign.infrastructure.services.TransacaoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClienteController {

    private final ExtratoService extratoService;
    private final TransacaoService transacaoService;

    @GetMapping(value="/clientes/{ClienteId}/extrato")
    public Extrato extrato(@PathVariable Integer ClienteId) throws NotFoundException {        
        Extrato response = extratoService.obtemExtrato(ClienteId);

        return response;
    }

    @PostMapping(value="/clientes/{ClienteId}/transacoes")
    public TransacaoResponse transacao(@PathVariable Integer ClienteId, @RequestBody TransacaoRequest transacaoRequest) throws NotFoundException, UnprocessableEntityException {
        transacaoRequest.setClienteId(ClienteId);                     
        TransacaoResponse response = transacaoService.efetuaTransacao(transacaoRequest);

        return response;
    }
}
