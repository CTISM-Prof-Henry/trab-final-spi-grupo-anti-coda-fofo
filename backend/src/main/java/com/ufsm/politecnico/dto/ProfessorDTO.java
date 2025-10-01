package com.ufsm.politecnico.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    private String nome;
    private String email;
    private String matricula;
    private Long id;
    private List<EventoDTO> eventos;
}
