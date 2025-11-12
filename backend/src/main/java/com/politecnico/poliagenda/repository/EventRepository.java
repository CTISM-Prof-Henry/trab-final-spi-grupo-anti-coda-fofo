package com.politecnico.poliagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.politecnico.poliagenda.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

} 
