package com.politecnico.poliagenda.domain;

import com.politecnico.poliagenda.domain.enums.Center;
import com.politecnico.poliagenda.domain.enums.RoomType;

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
@Table(name = "sala")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = "id")
public class Room{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "capacidade")
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private RoomType roomType;

    @Enumerated(EnumType.STRING)
    @Column(name = "predio")
    private Center center;
}
