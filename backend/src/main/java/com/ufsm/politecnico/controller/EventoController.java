package com.ufsm.politecnico.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ufsm.politecnico.dto.EventoDTO;
import com.ufsm.politecnico.service.EventoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/evento")
public class EventoController {

    private EventoService eventoService;

    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<EventoDTO>> findDTOs() {
        ArrayList<EventoDTO> eventosDTOs = this.eventoService.finDtos();
        return ResponseEntity.ok().body(eventosDTOs);
    }
    
}
