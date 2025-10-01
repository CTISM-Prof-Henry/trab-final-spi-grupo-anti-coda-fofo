package com.ufsm.politecnico.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufsm.politecnico.dto.ProfessorDTO;
import com.ufsm.politecnico.model.Professor;
import com.ufsm.politecnico.service.ProfessorService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private ProfessorService professorService;
    
    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    //selecionar todos os professores com seus devidos eventos
    @GetMapping
    public ResponseEntity<ArrayList<ProfessorDTO>> selectAll(){
        ArrayList<ProfessorDTO> professores = professorService.selectAll();
        return ResponseEntity.ok().body(professores);
    } 

    //seleciona o professor dado um email
    @GetMapping("/email")
    public ResponseEntity<Professor> getByEmail(@RequestParam String email) {
        return ResponseEntity.ok().body(professorService.getByEmail(email));
    }
    
    //seleciona o professor dado uma matricula
    @GetMapping("/matricula")
    public ResponseEntity<Professor> getByMatricula(@RequestParam String matricula){
        return ResponseEntity.ok().body(professorService.getByMatricula(matricula));
    }

    //seleciona o professor dado um id
    @GetMapping("/id")
    public ResponseEntity<Professor> getById(@RequestParam Long idProfessor) {
        return ResponseEntity.ok().body(professorService.getById(idProfessor));
    }
}
