package com.ufsm.politecnico.controller;


import com.ufsm.politecnico.model.Sala;
import com.ufsm.politecnico.repositories.SalaRepository;
import com.ufsm.politecnico.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sala")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }


    @GetMapping
    public List<Sala> sala(){
        return salaService.getSalas();
    }

    @GetMapping("{id}")
    public Sala getSala(@PathVariable long id){
        return salaService.getSala(id);
    }

    @PostMapping
    public Sala sala(@Valid @RequestBody Sala sala){
        return salaService.createSala(sala);
    }

    @DeleteMapping("{id}")
    public Boolean salaDelete(@PathVariable long id){
        return salaService.deleteSala(id);
    }
}
