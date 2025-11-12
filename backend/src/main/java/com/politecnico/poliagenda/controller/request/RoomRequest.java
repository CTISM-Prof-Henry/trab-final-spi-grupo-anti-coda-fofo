package com.politecnico.poliagenda.controller.request;

import com.politecnico.poliagenda.domain.enums.Center;
import com.politecnico.poliagenda.domain.enums.RoomType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequest {
    @Schema(example = "G201")
    @NotBlank
    private String name;

    @Schema(example = "LABORATÓRIO")
    private RoomType roomType;

    @Schema(example = "G")
    private Center center;

    @Schema(example = "40")
    @Min(value = 2)
    private int capacity;
}
