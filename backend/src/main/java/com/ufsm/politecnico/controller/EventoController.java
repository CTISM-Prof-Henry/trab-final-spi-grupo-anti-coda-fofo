package com.ufsm.politecnico.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/eventos")
public class EventoController {

    @GetMapping
    public String getMethodName(@RequestParam String param) {
        return new String("Endpoint de acesso ao recurso Eventos");
    }
    
}
