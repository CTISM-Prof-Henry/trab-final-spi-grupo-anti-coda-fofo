package com.politecnico.poliagenda.controller.request;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchedulingRequest {

    @NotNull(message = "A data do evento é obrigatória")
    @Future(message = "A data do evento deve ser no futuro")
    @Schema(example = "2025-10-20T10:00:00")
    private LocalDateTime startTime;

    @NotNull(message = "A data do evento é obrigatória")
    @Future(message = "A data do evento deve ser no futuro")
    @Schema(example = "2025-10-20T11:30:00")
    private LocalDateTime endTime;

    @NotNull(message = "id do evento é obrigatório")
    @Schema(example = "1L")
    private Long idEvent;

    @NotNull(message = "id da sala é obrigatória")
    @Schema(example = "1L")
    private Long idRoom;
}
