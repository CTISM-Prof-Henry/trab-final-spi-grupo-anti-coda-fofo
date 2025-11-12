package com.politecnico.poliagenda.controller.response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Schema(name = "HealthCheckResponse")
public class HealthCheckResponse {
    @Schema(example = "OK")
    private String status;
}
