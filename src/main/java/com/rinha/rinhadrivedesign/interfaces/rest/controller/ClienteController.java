package com.rinha.rinhadrivedesign.interfaces.rest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    @GetMapping(value="/clientes/{id}/extrato")
    public String extrato(@PathVariable Integer id)
    {
        return id.toString();
    }
}
