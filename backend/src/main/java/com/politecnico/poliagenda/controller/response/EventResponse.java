package com.politecnico.poliagenda.controller.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventResponse {
    private Long id;
    private String eventType;
    private String name;
    private String userEmail;
    private String userRegister;
}
