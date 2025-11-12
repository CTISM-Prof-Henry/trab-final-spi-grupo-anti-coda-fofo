package com.politecnico.poliagenda.service.event;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.politecnico.poliagenda.controller.request.EventRequest;
import com.politecnico.poliagenda.controller.response.EventResponse;
import com.politecnico.poliagenda.domain.Event;
import com.politecnico.poliagenda.domain.Users;
import com.politecnico.poliagenda.mapper.EventMapper;
import com.politecnico.poliagenda.repository.EventRepository;
import com.politecnico.poliagenda.service.AuthenticadedUserService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateEventService {
    
    private final EventRepository eventRepository;
    private final AuthenticadedUserService authenticadedUserService;

    @Transactional
    public EventResponse create(EventRequest request){
        //busca o usuario no contexto atual, se não achar não executa nada
        Users users = authenticadedUserService.get();
        if(users != null){
            Event newEvent = EventMapper.toEntity(request, users);
            eventRepository.save(newEvent);
            return EventMapper.toResponse(newEvent);
        }
        throw new NoSuchElementException("usuario não encontrado ou autenticado");
    }
}
