package com.ufsm.politecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufsm.politecnico.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
