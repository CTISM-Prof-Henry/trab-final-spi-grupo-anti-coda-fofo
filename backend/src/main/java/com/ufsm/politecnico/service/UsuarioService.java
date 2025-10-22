package com.ufsm.politecnico.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ufsm.politecnico.dto.request.UsuarioRequestDTO;
import com.ufsm.politecnico.dto.response.UsuarioResponseDTO;
import com.ufsm.politecnico.mapper.UsuarioMapper;
import com.ufsm.politecnico.model.Usuario;
import com.ufsm.politecnico.model.enums.Roles;
import com.ufsm.politecnico.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder bCrypt;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        this.bCrypt = new BCryptPasswordEncoder(12);
    }

    public UsuarioResponseDTO cadastrarProfessor(UsuarioRequestDTO u){
        Usuario novo = UsuarioMapper.toEntity(u);
        novo.setSenha(bCrypt.encode(u.getSenha())); //codifica a senha
        novo.setMatricula(u.getMatricula());//matricula pode ser opcional
        novo.setPermissao(Roles.ROLE_PROFESSOR);
        return UsuarioMapper.toResponseDTO(usuarioRepository.save(novo));
    }

    public List<UsuarioResponseDTO> listar(){
        return this.usuarioRepository.findAll().stream()
                .map(u -> UsuarioMapper.toResponseDTO(u))
                .toList();
    }
}
