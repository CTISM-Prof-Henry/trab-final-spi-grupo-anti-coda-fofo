package com.politecnico.poliagenda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.politecnico.poliagenda.controller.request.EventRequest;
import com.politecnico.poliagenda.controller.response.EventResponse;
import com.politecnico.poliagenda.service.event.CreateEventService;
import com.politecnico.poliagenda.service.event.ListEventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/events")
@AllArgsConstructor
@Tag(name = "Eventos", description = "Informações e operações de eventos")
public class EventController {

    private final CreateEventService createEventService;
    private final ListEventService listEventService;

    @Operation(summary = "Evento", description = "Listagem de eventos dos professores mediante filtros")
    @GetMapping("/list")
    public ResponseEntity<List<EventResponse>> list() {
        return ResponseEntity.ok().body(listEventService.listAll());
    }

    @Operation(summary = "Criar novo evento", description = "Cria um evento e associa com o usuario autenticado")
    @SecurityRequirement(name = "jwt_auth")
    @PostMapping("/post")
    public ResponseEntity<EventResponse> post(@RequestBody @Valid EventRequest dto) {
        return ResponseEntity.ok().body(createEventService.create(dto));
    }    
}
