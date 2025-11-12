package com.politecnico.poliagenda.service.room;

import org.springframework.stereotype.Service;

import com.politecnico.poliagenda.controller.request.RoomRequest;
import com.politecnico.poliagenda.controller.response.RoomResponse;
import com.politecnico.poliagenda.domain.Room;
import com.politecnico.poliagenda.mapper.RoomMapper;
import com.politecnico.poliagenda.repository.RoomRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateRoomService {

    private final RoomRepository roomRepository;

    public RoomResponse create(RoomRequest request){
        Room newRoom = RoomMapper.toEntity(request);
        newRoom = roomRepository.save(newRoom);
        return RoomMapper.toResponse(newRoom);
    }
}
