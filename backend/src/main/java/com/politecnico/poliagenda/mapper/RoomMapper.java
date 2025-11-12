package com.politecnico.poliagenda.mapper;

import com.politecnico.poliagenda.controller.request.RoomRequest;
import com.politecnico.poliagenda.controller.response.RoomResponse;
import com.politecnico.poliagenda.domain.Room;

public class RoomMapper {

    public static RoomResponse toResponse(Room room){
        return RoomResponse.builder()
            .name(room.getName())
            .center(room.getCenter().name())
            .roomType(room.getRoomType().name())
            .capacity(room.getCapacity())
            .id(room.getId())
            .build();
    }

    public static Room toEntity(RoomRequest dto){
        return Room.builder()
            .name(dto.getName())
            .capacity(dto.getCapacity())
            .center(dto.getCenter())
            .roomType(dto.getRoomType())
            .build();
    }
}
