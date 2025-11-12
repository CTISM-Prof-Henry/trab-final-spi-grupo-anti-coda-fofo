package com.politecnico.poliagenda.controller.request;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchedulingRequest {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long idEvento;
    private Long idSala;
}
