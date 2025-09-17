package com.ufsm.politecnico.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=3, message = "deve ter exatamente 3 a 5 char")
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoSala tipo;

    @Enumerated(EnumType.STRING)
    private TipoPredio predio;

    @Min(1)
    private int capacidade;

    //relacionamento com agendamento 1:N
    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos;
}
