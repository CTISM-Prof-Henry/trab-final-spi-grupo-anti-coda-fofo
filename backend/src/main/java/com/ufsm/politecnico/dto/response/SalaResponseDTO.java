package com.ufsm.politecnico.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaResponseDTO {
    private String nome;
    private String tipoSala;
    private String tipoPredio;
    private int capacidade;
    private Long id;
}
