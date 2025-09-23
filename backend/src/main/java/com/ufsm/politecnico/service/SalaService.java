package com.ufsm.politecnico.service;

import com.ufsm.politecnico.model.Sala;
import com.ufsm.politecnico.model.TipoPredio;
import com.ufsm.politecnico.model.TipoSala;
import com.ufsm.politecnico.repositories.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public List<Sala> getSalas(){
        return salaRepository.findAll();
    }

    public Sala getSala(Long id){

        Optional<Sala> sala = salaRepository.findById(id);
        if(sala.isPresent()){
            return sala.get();
        }
        throw new NoSuchElementException();
    }

    public Sala createSala(Sala sala){
        return salaRepository.save(sala);
    }

    public Sala updateSala(Sala sala){
        Optional<Sala> a = salaRepository.findById(sala.getId());
        if(a.isPresent()){

            a.get().setTipo(sala.getTipo());
            a.get().setNome(sala.getNome());
            a.get().setCapacidade(sala.getCapacidade());
            a.get().setPredio(sala.getPredio());
            salaRepository.save(a.get());
            return a.get();
        }

        throw new NoSuchElementException();
    }

    public Sala deleteSala(Long id){
        Optional<Sala> sala = salaRepository.findById(id);
        if(sala.isPresent()){
            salaRepository.delete(sala.get());
            return sala.get();
        }
        throw new NoSuchElementException();
    }

    //
    public List<Sala> findByPredio(TipoPredio tipoPredio){
        List<Sala> salas = salaRepository.findByPredio(tipoPredio);
        return salas;
    }

    //
    public List<Sala> findByTipo(TipoSala tipoSala){
        List<Sala> salas = salaRepository.findByTipo(tipoSala);
        return salas;
    }
    
}
