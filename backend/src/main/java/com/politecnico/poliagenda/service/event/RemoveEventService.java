package com.politecnico.poliagenda.service.event;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.politecnico.poliagenda.domain.Event;
import com.politecnico.poliagenda.repository.EventRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RemoveEventService {

    private final EventRepository eventRepository;

    @Transactional
    public void delete(Long id){
        Optional<Event> event = eventRepository.findById(id);
        if(event.isEmpty()){
            throw new NoSuchElementException("evento não encontrado");
        }
        else{
            eventRepository.deleteById(id);
        }
    }
}
