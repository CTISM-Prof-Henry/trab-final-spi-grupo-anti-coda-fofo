package com.politecnico.poliagenda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.politecnico.poliagenda.controller.request.SchedulingRequest;
import com.politecnico.poliagenda.controller.response.SchedulingResponse;
import com.politecnico.poliagenda.service.scheduling.CreateSchedulingService;
import com.politecnico.poliagenda.service.scheduling.ListSchedulingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/scheduling")
@RequiredArgsConstructor
@Tag(name = "Agendamento", description = "Operações para realizar agendamentos e consultas")
public class SchedulingController {

    private final CreateSchedulingService createSchedulingService;
    private final ListSchedulingService listSchedulingService;

    @PostMapping("/")
    @SecurityRequirement(name = "jwt_auth")
    @Operation(summary = "Criar Agendamento", description = "criação de agendamento seguindo regras")
    public ResponseEntity<SchedulingResponse> post(@RequestBody @Valid SchedulingRequest dto) {
        return ResponseEntity.ok().body(createSchedulingService.create((dto)));
    }

    @Operation(summary = "Listar Agendamentos", description = "listar todos os agendamentos por ordem decrescente de inicio")
    @GetMapping("/")
    public Page<SchedulingResponse> listarTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return listSchedulingService.listAll(PageRequest.of(page, size));
    }
    
}
