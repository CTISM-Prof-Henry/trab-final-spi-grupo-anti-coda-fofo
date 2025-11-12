package com.politecnico.poliagenda.controller.request;
import com.politecnico.poliagenda.domain.enums.EventType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {
    @Schema(example = "estruturas de dados")
    @Size(min = 3, max = 100, message = "string deve ter de 3 a 100 char")
    private String name;
    
    @Schema(example = "DISCIPLINA")
    private EventType type;
}
