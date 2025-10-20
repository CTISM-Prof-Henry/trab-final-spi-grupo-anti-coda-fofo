package com.ufsm.politecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ufsm.politecnico.model.Agendamento;

@Repository
public interface AgendamentoRepository 
        extends JpaRepository<Agendamento, Long> {
}
