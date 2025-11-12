package com.politecnico.poliagenda.domain;

import java.util.UUID;

import com.politecnico.poliagenda.domain.enums.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@ToString(of = "uuid")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "senha", nullable = false)
    private String password;

    @Column(name = "matricula")
    private String register;

    @Column(name = "permissao")
    @Enumerated(EnumType.STRING)
    private Roles role;
}
