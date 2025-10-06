package com.ufsm.politecnico.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.ufsm.politecnico.dto.AgendamentoDTO;
import com.ufsm.politecnico.dto.AgendamentoRequestDTO;
import com.ufsm.politecnico.model.Agendamento;
import com.ufsm.politecnico.service.AgendamentoService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
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

    @PostMapping
    public ResponseEntity<?> criarAgendamento(@RequestBody AgendamentoRequestDTO req) {
        AgendamentoDTO a = agendamentoService.criarAgendamento(
            req.getSalaId(),
            req.getEventoId(),
            req.getDataHoraInicio(),
            req.getDataHoraFim()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(a);
    }

    @DeleteMapping
    public ResponseEntity<?> deletarAgendamento(@RequestParam Long id){
        this.agendamentoService.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
    
}
