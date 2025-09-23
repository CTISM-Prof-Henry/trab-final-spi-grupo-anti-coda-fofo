package com.ufsm.politecnico.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.ufsm.politecnico.dto.AgendamentoDTO;
import com.ufsm.politecnico.model.Agendamento;
import com.ufsm.politecnico.service.AgendamentoService;


@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {
    private AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService){
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<AgendamentoDTO>> findAll(){
        ArrayList<AgendamentoDTO> dados = this.agendamentoService.findAllDTO();
        return ResponseEntity.ok().body(dados);
    }
}
