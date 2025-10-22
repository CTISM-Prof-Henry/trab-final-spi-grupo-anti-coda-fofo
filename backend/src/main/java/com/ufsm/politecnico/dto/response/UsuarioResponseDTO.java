package com.ufsm.politecnico.dto.response;

import com.ufsm.politecnico.model.enums.Roles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class UsuarioResponseDTO {
    @NonNull
    private String email;
    @NonNull
    private String nome;
    @NonNull
    private Roles permissao;
}
