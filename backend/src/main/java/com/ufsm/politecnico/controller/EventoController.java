package com.ufsm.politecnico.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufsm.politecnico.dto.request.EventoRequestDTO;
import com.ufsm.politecnico.model.enums.TipoEvento;
import com.ufsm.politecnico.service.EventoService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }

    //lista os eventos de professores, o tipo e professor é opcional
    @GetMapping
    public ResponseEntity<?> listar(
            @RequestParam(required = false) TipoEvento tipo,
            @RequestParam(required = false) String professor) {
        return ResponseEntity.ok().body(eventoService.listar(tipo, professor));
    }

    //cadastrar novo evento apenas para usuarios autenticado
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EventoRequestDTO request){
        return ResponseEntity.ok().body(eventoService.cadastrar(request));
    }

    //excluir evento
    @DeleteMapping
    public ResponseEntity<?> excluir(@RequestParam Long id){
        return ResponseEntity.ok().body(eventoService.excluir(id));
    }
}
