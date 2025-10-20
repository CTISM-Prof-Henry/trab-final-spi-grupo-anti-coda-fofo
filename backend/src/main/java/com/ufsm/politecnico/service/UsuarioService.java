package com.ufsm.politecnico.service;

import org.springframework.stereotype.Service;

import com.ufsm.politecnico.dto.request.UsuarioRequestDTO;
import com.ufsm.politecnico.dto.response.UsuarioResponseDTO;
import com.ufsm.politecnico.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    public void cadastrarProfessor(UsuarioRequestDTO u){
        
    }
}
