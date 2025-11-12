package com.politecnico.poliagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.politecnico.poliagenda.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    
} 

