package com.politecnico.poliagenda.service.scheduling;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.politecnico.poliagenda.controller.response.SchedulingResponse;
import com.politecnico.poliagenda.mapper.SchedulingMapper;
import com.politecnico.poliagenda.repository.SchedulingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListSchedulingService {
    private final SchedulingRepository schedulingRepository;

    public Page<SchedulingResponse> listAll(Pageable pageable){
        return schedulingRepository.findAllOrderByStartTimeDesc(pageable)
            .map(s -> SchedulingMapper.toResponse(s));
    }

    public Page<SchedulingResponse> listByPeriod(
            LocalDateTime startTime,
            LocalDateTime endTime,
            Pageable pageable
            ){
        return schedulingRepository.findByPeriod(startTime, endTime, pageable)
            .map(s -> SchedulingMapper.toResponse(s));
    }
}
