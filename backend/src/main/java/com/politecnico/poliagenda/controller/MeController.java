package com.politecnico.poliagenda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.politecnico.poliagenda.controller.response.UserResponse;
import com.politecnico.poliagenda.service.AuthenticadedUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/me")
@AllArgsConstructor
@Tag(name = "Perfil", description = "Operações do usuário autenticado")
public class MeController {

    private final AuthenticadedUserService authenticadedUserService;

    @Operation(summary = "Dados do usuario autenticado", description = "Retorna dados do usuário autenticado")
    @SecurityRequirement(name = "jwt_auth")
    @GetMapping("/")
    public ResponseEntity<UserResponse> me() {
        return ResponseEntity.ok().body(authenticadedUserService.getToResponse());
    }
    
}
