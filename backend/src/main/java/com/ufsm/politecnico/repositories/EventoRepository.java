package com.ufsm.politecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufsm.politecnico.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

}
