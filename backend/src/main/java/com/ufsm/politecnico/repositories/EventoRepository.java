package com.ufsm.politecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufsm.politecnico.model.Evento;
import java.util.List;
import java.util.Optional;


@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{
    //listar eventos de um professor específico
    List<Evento> findByProfessorId(Long idProfessor);

    //obter evento de um id
    Optional<Evento> findById(Long id);

    //obter eventos por tipo específico
    
}
