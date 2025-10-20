package com.ufsm.politecnico.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    
    @GetMapping
    public String getMethodName(@RequestParam String param) {
        return new String("Endpoin de acesso ao recurso agendamentos");
    }
    
}
