package com.politecnico.poliagenda.controller.request;

import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    @NotNull(message = "O campo email é obrigatório")
    @Email(message = "O campo email deve ser um email válido")
    @Schema(example = "jose@exemplo.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotNull(message = "O campo de senha é obrigatório")
    @Length(min = 6, max = 100, message = "A senha deve conter no mínimo 6 dígitos")
    @Schema(example = "123456", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
}
