package com.politecnico.poliagenda.mapper;

import com.politecnico.poliagenda.controller.request.EventRequest;
import com.politecnico.poliagenda.controller.response.EventResponse;
import com.politecnico.poliagenda.domain.Event;
import com.politecnico.poliagenda.domain.Users;

public class EventMapper {

    public static EventResponse toResponse(Event event){
        return EventResponse.builder()
            .id(event.getId())
            .name(event.getName())
            .eventType(event.getEventType().name())
            .userEmail(event.getUser().getEmail())
            .userRegister(event.getUser().getRegister())
            .build();
    }

    public static Event toEntity(EventRequest dto, Users userEvent){
        return Event.builder()
            .name(dto.getName())
            .eventType(dto.getType())
            .user(userEvent)
            .build();
    }
}
