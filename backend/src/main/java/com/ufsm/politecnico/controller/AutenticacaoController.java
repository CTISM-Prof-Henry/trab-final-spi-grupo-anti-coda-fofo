package com.ufsm.politecnico.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufsm.politecnico.dto.request.LoginRequestDTO;
import com.ufsm.politecnico.dto.response.LoginResponseDTO;
import com.ufsm.politecnico.security.TokenServiceJWT;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenServiceJWT tokenServiceJWT;

    public AutenticacaoController(AuthenticationManager manager, TokenServiceJWT tokenServiceJWT){
        this.manager = manager;
        this.tokenServiceJWT = tokenServiceJWT;
    }

    //método principal para retornar o token apos o login bem sucedido no corpo da resposta
    @PostMapping
    public ResponseEntity<?> fazerLogin(@RequestBody @Valid LoginRequestDTO login) {
        Authentication aut = new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha());
        Authentication autOk = manager.authenticate(aut);
        String token = tokenServiceJWT.gerarToken((User) autOk.getPrincipal());
        return ResponseEntity.ok().body(new LoginResponseDTO(token));
    }
    
}
