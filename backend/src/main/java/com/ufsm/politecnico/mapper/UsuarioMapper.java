package com.ufsm.politecnico.mapper;

import com.ufsm.politecnico.dto.request.UsuarioRequestDTO;
import com.ufsm.politecnico.dto.response.UsuarioResponseDTO;
import com.ufsm.politecnico.model.Usuario;

public class UsuarioMapper {
    public static UsuarioResponseDTO toResponseDTO(Usuario usuario){
        if(usuario == null) return null;   
        return new UsuarioResponseDTO(usuario.getEmail(), usuario.getNome(), usuario.getPermissao());
    }

    public static Usuario toEntity(UsuarioRequestDTO u){
        if(u == null) return null;
        Usuario usuario = new Usuario(u.getNome(), u.getEmail(), u.getSenha());
        return usuario;
    }
}
