package com.politecnico.poliagenda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.politecnico.poliagenda.controller.request.AuthRequest;
import com.politecnico.poliagenda.controller.response.AuthResponse;
import com.politecnico.poliagenda.service.TokenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
@Tag(name = "Autenticação", description = "Operações de autenticação de usuários")
public class AuthController {

    private final TokenService tokenService;

    @Operation(summary = "Token JWT", description = "Criação de um token JWT para o usuário")
    @PostMapping
    public ResponseEntity<AuthResponse> authenticate(@RequestBody @Valid AuthRequest dto) {
        return ResponseEntity.ok().body(tokenService.authenticate(dto));
    }
    
}
