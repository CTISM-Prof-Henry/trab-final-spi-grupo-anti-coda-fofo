package com.politecnico.poliagenda.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.politecnico.poliagenda.domain.Scheduling;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {

    @Query("SELECT s FROM Scheduling s ORDER BY s.startTime DESC")
    Page<Scheduling> findAllOrderByStartTimeDesc(Pageable pageable);

    @Query("""
           SELECT s FROM Scheduling s
           WHERE s.startTime >= :inicio
             AND s.endTime <= :fim
           ORDER BY s.startTime DESC
           """)
    Page<Scheduling> findByPeriod(
            @Param("inicio") LocalDateTime inicio,
            @Param("fim") LocalDateTime fim,
            Pageable pageable
    );
}
