package com.politecnico.poliagenda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.politecnico.poliagenda.controller.response.HealthCheckResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/health")
@Tag(name = "Health", description = "Operações de checkagem do cliclo de vida da API.")
public class Health {

    @GetMapping("/")
    public HealthCheckResponse check(){
        return HealthCheckResponse.builder()
            .status("OK")
            .build();
    }
}
