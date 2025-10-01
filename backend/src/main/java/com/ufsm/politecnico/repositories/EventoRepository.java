package com.ufsm.politecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufsm.politecnico.dto.EventoDTO;
import com.ufsm.politecnico.model.Evento;
import com.ufsm.politecnico.model.TipoEvento;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{
    //listar eventos de um professor específico

    //obter evento de um id
    public Optional<Evento> findById(Long id);

    //obter eventos por tipo específico
    public ArrayList<Evento> findByTipo(TipoEvento tipo);

    //obter eventos por um nome especifico
    public Optional<Evento> findByNome(String nome);
}
