package com.ufsm.politecnico.controller;


import com.ufsm.politecnico.model.Sala;
import com.ufsm.politecnico.model.TipoPredio;
import com.ufsm.politecnico.model.TipoSala;
import com.ufsm.politecnico.service.SalaService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/sala")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public ResponseEntity<List<Sala>> salas(){
        List<Sala> salas = salaService.getSalas();
        return ResponseEntity.ok().body(salas);
    }

    @GetMapping("/predio")
    public ResponseEntity<?> predio(@RequestParam TipoPredio predio) {
        List<Sala> salas= salaService.findByPredio(predio);
        return ResponseEntity.ok().body(salas);
    }

    @GetMapping("/tipo")
    public ResponseEntity<?> tipo(@RequestParam TipoSala tipo) {
        List<Sala> salas = salaService.findByTipo(tipo);
        return ResponseEntity.ok().body(salas);
    }

    @GetMapping
    public ResponseEntity<Sala> id(@RequestParam long id){
        Sala s = salaService.getSala(id);
        return ResponseEntity.ok().body(s);
    }

    @PostMapping
    public ResponseEntity<Sala> createSala(@Valid @RequestBody Sala sala){
        Sala s = salaService.createSala(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }

    //operação de exclusão não gera um corpo de resposta por padrão
    @DeleteMapping("{id}")
    public ResponseEntity<Sala> salaDelete(@RequestParam long id){
        salaService.deleteSala(id);
        return ResponseEntity.noContent().build();
    }
}
