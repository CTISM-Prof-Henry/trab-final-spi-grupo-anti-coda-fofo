package com.politecnico.poliagenda.controller.request;

import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatedUserRequest {
    @NotNull(message = "matricula é obrigatória")
    @Schema(example = "123456789")
    private  String register;

    @NotNull(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    @Schema(example = "jhondoe@exemplo.com")
    private  String email;

    @NotNull(message = "Senha é obrigatória")
    @Length(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 dígitos")
    private  String password;
}
