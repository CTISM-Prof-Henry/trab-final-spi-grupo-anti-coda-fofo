package com.ufsm.politecnico.dto.request;

import com.ufsm.politecnico.model.enums.TipoEvento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventoRequestDTO {
    private String nome;
    private Long id_professor;
    private TipoEvento tipo;
}
