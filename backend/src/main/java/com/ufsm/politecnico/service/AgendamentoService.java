package com.ufsm.politecnico.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ufsm.politecnico.dto.AgendamentoDTO;
import com.ufsm.politecnico.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {
    
    private AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository ar){
        this.agendamentoRepository = ar;
    }

    public List<AgendamentoDTO> buscarAgendamentoDTOs(){
        return agendamentoRepository.buscarTodosAgendamentos();
    }

    public List<AgendamentoDTO> buscarAgendamentosFuturos(){
        return agendamentoRepository.buscarAgendamentosFuturos(LocalDateTime.now());
    }

    public List<AgendamentoDTO> buscarAgendamentosPassados(){
        return agendamentoRepository.buscarAgendamentosPassados(LocalDateTime.now());
    }

    public List<AgendamentoDTO> buscarAgendamentosPeriodo(
            LocalDateTime inicio, LocalDateTime fim){
        //logica para validar data
        return agendamentoRepository.buscarAgendamentosPorPeriodo(inicio, fim);
    }
}
