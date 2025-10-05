package com.ufsm.politecnico.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.ufsm.politecnico.dto.AgendamentoDTO;
import com.ufsm.politecnico.service.AgendamentoService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {
    private AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService){
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> findAll(){
        List<AgendamentoDTO> dados = this.agendamentoService.buscarAgendamentoDTOs();
        return ResponseEntity.ok().body(dados);
    }

    @GetMapping("/futuros")
    public ResponseEntity<List<AgendamentoDTO>> findFuturos() {
        List<AgendamentoDTO> dados = this.agendamentoService.buscarAgendamentosFuturos();
        return ResponseEntity.ok().body(dados);
    }

    @GetMapping("/passados")
    public ResponseEntity<List<AgendamentoDTO>> findPassados(){
        List<AgendamentoDTO> dados = this.agendamentoService.buscarAgendamentosPassados();
        return ResponseEntity.ok().body(dados);
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<AgendamentoDTO>> findPeriodo(
            @RequestParam("inicio") LocalDateTime inicio,
            @RequestParam("fim") LocalDateTime fim) 
    {
        List<AgendamentoDTO> dados = 
            this.agendamentoService.buscarAgendamentosPeriodo(inicio, fim);

        return ResponseEntity.ok().body(dados);
    }
}
