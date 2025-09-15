package com.ufsm.politecnico.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
@Table(name = "professor")
public class Professor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email
    @Size(min = 6, max=100, message = "tamanho de string email invalida")
    private String email;

    @NotBlank
    @Size(min = 6, message = "senha deve ter mais que 6 caracteres")
    private String senha;

    @NotBlank
    @Size(min = 9, max = 9, message="matricula deve ter 9 char")
    private String matricula;

    //Relacionamento com eventos, evento em cascatas para crud
    @OneToMany(
        mappedBy = "professor", 
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<Evento> eventos;
}