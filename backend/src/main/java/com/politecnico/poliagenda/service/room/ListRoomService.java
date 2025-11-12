package com.politecnico.poliagenda.service.room;

import java.util.List;

import org.springframework.stereotype.Service;

import com.politecnico.poliagenda.controller.response.RoomResponse;
import com.politecnico.poliagenda.mapper.RoomMapper;
import com.politecnico.poliagenda.repository.RoomRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListRoomService {

    private final RoomRepository roomRepository;

    public List<RoomResponse> listAll(){
        return roomRepository.findAll()
            .stream()
            .map(r -> (RoomMapper.toResponse(r)))
            .toList();
    }
}
