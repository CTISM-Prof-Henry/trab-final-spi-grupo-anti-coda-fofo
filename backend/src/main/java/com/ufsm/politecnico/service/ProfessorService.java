package com.ufsm.politecnico.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufsm.politecnico.model.Evento;
import com.ufsm.politecnico.model.Professor;
import com.ufsm.politecnico.repositories.ProfessorRepository;
import com.ufsm.politecnico.dto.EventoDTO;
import com.ufsm.politecnico.dto.ProfessorDTO;

@Service
public class ProfessorService {
    //inicialização de dependencia
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository pr){
        this.professorRepository = pr;
    }

    /*listar todos os professores
     * cada qual com seus eventosDTO associados
     * cada evento tem apenas o nome
    */
    public ArrayList<ProfessorDTO> selectAll(){
        ArrayList<ProfessorDTO> professorDTOs = new ArrayList<ProfessorDTO>();
        List<Professor> professores = professorRepository.findAll();
        Iterator<Professor> i = professores.iterator();
        while(i.hasNext()){
            Professor p = i.next();

            ProfessorDTO p2 = new ProfessorDTO(
                p.getNome(),
                p.getEmail(),
                p.getMatricula(),
                p.getId(),
                new ArrayList<EventoDTO>()
            );

            for (Evento iEvento : p.getEventos()) {
                EventoDTO novo = new EventoDTO();
                novo.setNome(iEvento.getNome());
                novo.setTipo(iEvento.getTipo().name());
                p2.getEventos().add(novo);
            }
            professorDTOs.add(p2);
        }
        return professorDTOs;
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
