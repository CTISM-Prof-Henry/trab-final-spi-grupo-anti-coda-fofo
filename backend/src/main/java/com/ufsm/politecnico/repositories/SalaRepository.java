package com.ufsm.politecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufsm.politecnico.model.Sala;
import com.ufsm.politecnico.model.enums.TipoPredio;
import com.ufsm.politecnico.model.enums.TipoSala;

import java.util.List;


@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
    
    //filtrar por tipo de pŕedio
    public List<Sala> findByPredio(TipoPredio predio);
    
    //filtrar por tipo de sala
    public List<Sala> findByTipo(TipoSala tipo);
} 
