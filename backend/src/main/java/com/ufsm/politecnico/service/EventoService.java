package com.ufsm.politecnico.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ufsm.politecnico.dto.EventoDTO;
import com.ufsm.politecnico.model.Evento;
import com.ufsm.politecnico.model.TipoEvento;
import com.ufsm.politecnico.repositories.EventoRepository;

@Service
public class EventoService {

    private EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    public ArrayList<EventoDTO> finDtos(){
        ArrayList<EventoDTO> eventoDTOs = new ArrayList<EventoDTO>();
        List<Evento> eventos = this.eventoRepository.findAll();
        Iterator<Evento> i = eventos.iterator();
        while (i.hasNext()) {
            Evento e = i.next();
            eventoDTOs.add(new EventoDTO(
                e.getId(),
                e.getNome(),
                e.getTipo().name(),
                e.getProfessor().getNome()
            ));
        }
        return eventoDTOs;
    }

    public ArrayList<EventoDTO> findDtosByTipo(TipoEvento t){
        ArrayList<Evento> eventos = this.eventoRepository.findByTipo(t);
        ArrayList<EventoDTO> eventosDTO = new ArrayList<EventoDTO>();
        Iterator<Evento> i = eventos.iterator();

        while (i.hasNext()) {
            Evento e = i.next();
            eventosDTO.add(new EventoDTO(
                e.getId(),
                e.getNome(),
                e.getTipo().name(),
                e.getProfessor().getNome()
            ));
        }
        return eventosDTO;
    }
}
