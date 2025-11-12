package com.politecnico.poliagenda.mapper;

import com.politecnico.poliagenda.controller.response.SchedulingResponse;
import com.politecnico.poliagenda.domain.Scheduling;

public class SchedulingMapper {
    public static SchedulingResponse toResponse(Scheduling scheduling){
        return SchedulingResponse.builder()
            .startTime(scheduling.getStartTime())
            .endTime(scheduling.getEndTime())
            .eventName(scheduling.getEvent().getName())
            .eventType(scheduling.getEvent().getEventType().name())
            .eventUserName(scheduling.getEvent().getUser().getEmail())
            .roomName(scheduling.getRoom().getName())
            .roomCenter(scheduling.getRoom().getCenter().name())
            .roomType(scheduling.getRoom().getRoomType().name())
            .id(scheduling.getId())
            .build();
    }
}
