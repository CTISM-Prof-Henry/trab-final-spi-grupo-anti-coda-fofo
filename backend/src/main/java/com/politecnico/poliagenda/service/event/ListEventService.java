package com.politecnico.poliagenda.service.event;

import java.util.List;
import org.springframework.stereotype.Service;
import com.politecnico.poliagenda.controller.response.EventResponse;
import com.politecnico.poliagenda.mapper.EventMapper;
import com.politecnico.poliagenda.repository.EventRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListEventService {

    private final EventRepository eventRepository;

    public List<EventResponse> listAll(){
        return eventRepository.findAll()
            .stream()
            .map(e -> EventMapper.toResponse(e))
            .toList();
    }
}
