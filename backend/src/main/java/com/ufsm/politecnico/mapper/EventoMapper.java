package com.ufsm.politecnico.mapper;

import com.ufsm.politecnico.dto.response.EventoResponseDTO;
import com.ufsm.politecnico.dto.request.EventoRequestDTO;
import com.ufsm.politecnico.model.Evento;
import com.ufsm.politecnico.model.Usuario;

public class EventoMapper {

    public static Evento toEntity(EventoRequestDTO evento, Usuario u){
        Evento e = new Evento();
        e.setNome(evento.getNome());
        e.setTipo(evento.getTipo());
        e.setUsuario(u);
        return e;
    }

    public static EventoResponseDTO toResponse(Evento evento){
        return new EventoResponseDTO(
            evento.getId(),
            evento.getNome(),
            evento.getTipo().name(),
            evento.getUsuario().getNome()
        );
    }
}
