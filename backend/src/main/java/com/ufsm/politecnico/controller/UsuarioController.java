package com.ufsm.politecnico.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufsm.politecnico.dto.request.UsuarioRequestDTO;
import com.ufsm.politecnico.dto.response.UsuarioResponseDTO;
import com.ufsm.politecnico.service.UsuarioService;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/usuario")
public class UsuarioController{

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    //cria um novo usuario com a role PROFESSOR por padrão
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody @Valid UsuarioRequestDTO usuario){
        return ResponseEntity.ok().body(usuarioService.cadastrarProfessor(usuario));
    }

    //lista todos os usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        return ResponseEntity.ok().body(usuarioService.listar());
    }
    
}
