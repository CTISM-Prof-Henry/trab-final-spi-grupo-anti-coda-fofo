package com.politecnico.poliagenda.service.room;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.politecnico.poliagenda.domain.Room;
import com.politecnico.poliagenda.repository.RoomRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RemoveRoomService {

    private final RoomRepository roomRepository;

    @Transactional
    public void delete(Long id){
        Optional<Room> room = roomRepository.findById(id);
        if(room.isEmpty()){
            throw new NoSuchElementException("sala nao encontrada");
        }
        else{
            roomRepository.deleteById(id);;
        }
    }
}
