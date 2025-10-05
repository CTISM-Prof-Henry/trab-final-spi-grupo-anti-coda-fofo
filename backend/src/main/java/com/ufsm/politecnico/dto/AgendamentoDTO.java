package com.ufsm.politecnico.dto;

import java.time.LocalDateTime;

import com.ufsm.politecnico.model.TipoPredio;
import com.ufsm.politecnico.model.TipoSala;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AgendamentoDTO {
    private Long id;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String nomeSala;
    private String nomeEvento;
    private String nomeProfessor;
    private TipoSala tipoSala;
    private TipoPredio tipoPredio;

    //construtor explicito para evitar erro 
    public AgendamentoDTO(Long id, LocalDateTime dataHoraInicio,
            LocalDateTime dataHoraFim, String nomeSala,
            String nomeEvento, String nomeProfessor,
            TipoSala tipoSala, TipoPredio tipoPredio){
        this.id = id;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.nomeSala = nomeSala;
        this.nomeEvento = nomeEvento;
        this.nomeProfessor = nomeProfessor;
        this.tipoSala = tipoSala;
        this.tipoPredio = tipoPredio;
    }
}
