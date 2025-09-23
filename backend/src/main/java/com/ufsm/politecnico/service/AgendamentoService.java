package com.ufsm.politecnico.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ufsm.politecnico.dto.AgendamentoDTO;
import com.ufsm.politecnico.model.Agendamento;
import com.ufsm.politecnico.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {
    
    private AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository ar){
        this.agendamentoRepository = ar;
    }

    public ArrayList<AgendamentoDTO> findAllDTO(){
        List<Agendamento> agendamentos = this.agendamentoRepository.findAll();
        ArrayList<AgendamentoDTO> agendamentoDTOs = new ArrayList<AgendamentoDTO>();
        for (Agendamento a : agendamentos) {
            AgendamentoDTO newA = new AgendamentoDTO(
                a.getId(),
                a.getDataHoraInicio(),
                a.getDataHoraFim(),
                a.getSala().getNome(),
                a.getEvento().getNome(),
                a.getEvento().getTipo().name(),
                a.getSala().getTipo().name()
            );
            agendamentoDTOs.add(newA);
        }
        return agendamentoDTOs;
    }
}
