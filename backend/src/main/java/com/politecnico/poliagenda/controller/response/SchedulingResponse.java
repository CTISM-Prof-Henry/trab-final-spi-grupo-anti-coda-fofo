package com.politecnico.poliagenda.controller.response;
import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchedulingResponse {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String eventName;
    private String eventType;
    private String roomName;
    private String roomType;
    private String roomCenter;
    private String eventUserName;
}
