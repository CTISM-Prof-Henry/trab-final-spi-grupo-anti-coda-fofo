package com.politecnico.poliagenda.controller.response;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {

    @Schema(example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(example = "123456789")
    private String register;

    @Schema(example = "jhondoe@exemplo.com")
    private String email;

    @Schema(example = "ROLE_ADMIN")
    private String role;
}
