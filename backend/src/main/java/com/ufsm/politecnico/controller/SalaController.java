package com.ufsm.politecnico.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/salas")
public class SalaController {
   
    @GetMapping
    public String getMethodName(@RequestParam String param) {
        return new String("Endpoint para o recurso salas");
    }
    
    /*
    * Filtrar salas por tipo e prédio
    * Quando um parâmetro não for especificado, será filtrado por todos
    * Todos tem permissão para acessar este endpoint
    */

    
    /*
    * Criar uma sala nova, apenas Usuarios com a permissão admin 
    */
    
    /*
    * Deletar uma sala, Apenas Usuarios com a permissão admin 
    */
}
