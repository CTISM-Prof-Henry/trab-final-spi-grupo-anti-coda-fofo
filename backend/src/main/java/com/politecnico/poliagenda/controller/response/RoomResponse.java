package com.politecnico.poliagenda.controller.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomResponse {
    private Long id;
    private String name;
    private String roomType;
    private String center;
    private int capacity;
}
