package com.ufsm.politecnico.dto.request;

import com.ufsm.politecnico.model.enums.Roles;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioRequestDTO {
    @NonNull
    private String nome;
    @NonNull
    @Size(min=6, message = "senha deve ter no mínimo 6 char")
    private String senha;
    @NonNull
    @Email(message = "email inválido")
    private String email;
    @NonNull
    private String matricula;
}
