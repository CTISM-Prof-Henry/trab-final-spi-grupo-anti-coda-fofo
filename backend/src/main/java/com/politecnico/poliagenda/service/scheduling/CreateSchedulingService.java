package com.politecnico.poliagenda.service.scheduling;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.politecnico.poliagenda.controller.request.SchedulingRequest;
import com.politecnico.poliagenda.controller.response.SchedulingResponse;
import com.politecnico.poliagenda.domain.Event;
import com.politecnico.poliagenda.domain.Room;
import com.politecnico.poliagenda.domain.Scheduling;
import com.politecnico.poliagenda.mapper.SchedulingMapper;
import com.politecnico.poliagenda.repository.EventRepository;
import com.politecnico.poliagenda.repository.RoomRepository;
import com.politecnico.poliagenda.repository.SchedulingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateSchedulingService {

    private final SchedulingRepository schedulingRepository;
    private final EventRepository eventRepository;
    private final RoomRepository roomRepository;

    public SchedulingResponse create(SchedulingRequest request){
        Optional<Room> room = roomRepository.findById(request.getIdRoom());
        if(room.isEmpty()) throw new NoSuchElementException("sala não encontrada");
        Optional<Event> event = eventRepository.findById(request.getIdEvent());
        if(event.isEmpty()) throw new NoSuchElementException("evento não encontrado");

        Scheduling newScheduling = Scheduling.builder()
            .startTime(request.getStartTime())
            .endTime(request.getEndTime())
            .room(room.get())
            .event(event.get())
            .build();
        
        Scheduling saved = schedulingRepository.save(newScheduling);
        return SchedulingMapper.toResponse(saved);
    }
}
