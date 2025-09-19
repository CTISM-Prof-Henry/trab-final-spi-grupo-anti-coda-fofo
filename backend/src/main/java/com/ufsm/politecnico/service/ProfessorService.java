package com.ufsm.politecnico.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufsm.politecnico.model.Professor;
import com.ufsm.politecnico.repositories.ProfessorRepository;

@Service
public class ProfessorService {
    //inicialização de dependencia
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository pr){
        this.professorRepository = pr;
    }

    //listar todos os professores
    public List<Professor> selectAll(){
        return professorRepository.findAll();
    }

    //obter o professor de uma matricula
    public Professor getByMatricula(String matricula){
        return professorRepository.findByMatricula(matricula)
        .orElseThrow();
    }

    //obter o professor de um email
    public Professor getByEmail(String email){
        return professorRepository.findByEmail(email)
        .orElseThrow();
    }

    //obter o professor por um id
    public Professor getById(Long id){
        return professorRepository.findById(id)
        .orElseThrow();
    }

    //deletar um professor
    public Professor delete(Long id){
        Optional<Professor> deletado = professorRepository.findById(id);
        if(deletado.isPresent()){
            professorRepository.deleteById(id);
            return deletado.get();
        }
        throw new NoSuchElementException();
    }

    //criar um professor
    public Professor create(Professor professor){
        return professorRepository.save(professor);
    }

    //editar um professor
    //permito somente nome, email e senha novos
    public Professor edit(Professor alteracao){
        Optional<Professor> p = professorRepository.findById(alteracao.getId());
        if(p.isPresent()){
            p.get().setEmail(alteracao.getEmail());
            p.get().setNome(alteracao.getNome());
            p.get().setSenha(alteracao.getSenha());
            professorRepository.save(p.get());
        }
        throw new NoSuchElementException();
    }
}
