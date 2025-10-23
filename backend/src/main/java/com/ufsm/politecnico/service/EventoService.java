package com.ufsm.politecnico.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufsm.politecnico.dto.request.EventoRequestDTO;
import com.ufsm.politecnico.dto.response.EventoResponseDTO;
import com.ufsm.politecnico.mapper.EventoMapper;
import com.ufsm.politecnico.model.Evento;
import com.ufsm.politecnico.model.Usuario;
import com.ufsm.politecnico.model.enums.TipoEvento;
import com.ufsm.politecnico.repositories.EventoRepository;
import com.ufsm.politecnico.repositories.UsuarioRepository;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final UsuarioRepository usuarioRepository;

    public EventoService(EventoRepository eventoRepository, UsuarioRepository usuarioRepository){
        this.eventoRepository = eventoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    //listar eventos aplicando mappers e filtros personalizados
    public List<EventoResponseDTO> listar(TipoEvento tipo, String professor){
        List<Evento> eventos = eventoRepository.findByTipoAndNome(tipo, professor);
        return eventos.stream()
            .map(e -> EventoMapper.toResponse(e))
            .toList();
    }

    //cadastar evento
    public EventoResponseDTO cadastrar(EventoRequestDTO evento){
        Optional<Usuario> u = usuarioRepository.findById(evento.getId_professor());
        if(!u.isPresent()) throw new NoSuchElementException("usuario com id não encontrado");

        Evento e = eventoRepository.save(EventoMapper.toEntity(evento, u.get()));
        return EventoMapper.toResponse(e);
    }

    //a
    public EventoResponseDTO excluir(long id){
        Optional<Evento> e = eventoRepository.findById(id);
        if(!e.isPresent()) throw new NoSuchElementException();
        eventoRepository.delete(e.get());
        return EventoMapper.toResponse(e.get());
    }
}
