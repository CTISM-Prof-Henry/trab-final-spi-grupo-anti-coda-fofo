package com.ufsm.politecnico.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufsm.politecnico.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

    //buscar professor pelo id
    public Optional<Professor> findById(Long id);

    //buscar professor pela matricula
    public Optional<Professor>  findByMatricula(String matricula);

    //buscar por email
    public Optional<Professor> findByEmail(String email);
}
