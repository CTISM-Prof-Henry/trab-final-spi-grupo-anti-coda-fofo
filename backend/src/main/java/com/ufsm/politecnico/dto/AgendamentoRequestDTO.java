package com.ufsm.politecnico.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoRequestDTO {
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private Long salaId;
    private Long eventoId;
}
