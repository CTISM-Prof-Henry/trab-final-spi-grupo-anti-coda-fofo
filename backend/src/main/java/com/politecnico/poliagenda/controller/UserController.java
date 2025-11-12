package com.politecnico.poliagenda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.politecnico.poliagenda.controller.request.CreatedUserRequest;
import com.politecnico.poliagenda.controller.response.UserResponse;
import com.politecnico.poliagenda.service.users.CreateUserService;
import com.politecnico.poliagenda.service.users.ListUsers;

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
@RequestMapping("/users")
@Tag(name = "Usuários", description = "Informações dos usuários")
@AllArgsConstructor
public class UserController {

    private final CreateUserService createUserService;
    private final ListUsers listUsers;

    @Operation(summary = "Listagem de usuários cadastrados", description = "Lista de usuários")
    @SecurityRequirement(name = "jwt_auth")
    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> list() {
        return ResponseEntity.ok().body(listUsers.listUsers());
    }

    @Operation(summary = "Criação de usuário", description = "Criação de um novo usuário no sistema")
    @SecurityRequirement(name = "jwt_auth")
    @PostMapping("/")
    public ResponseEntity<UserResponse> postNewUser(@RequestBody @Valid CreatedUserRequest dto ) {
        return ResponseEntity.ok().body(createUserService.create(dto));
    }
    
    
}
