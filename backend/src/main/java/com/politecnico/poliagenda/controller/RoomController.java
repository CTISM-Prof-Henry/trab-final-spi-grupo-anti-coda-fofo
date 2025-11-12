package com.politecnico.poliagenda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.politecnico.poliagenda.controller.request.RoomRequest;
import com.politecnico.poliagenda.controller.response.RoomResponse;
import com.politecnico.poliagenda.service.room.CreateRoomService;
import com.politecnico.poliagenda.service.room.ListRoomService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/rooms")
@AllArgsConstructor
@Tag(name = "Salas", description = "Informações e operações de salas")
public class RoomController {

    private final CreateRoomService createRoomService;
    private final ListRoomService listRoomService;

    @Operation(summary = "Listar Salas", description = "Ver informações de salas com filtros")
    @GetMapping("/")
    public ResponseEntity<List<RoomResponse>> list() {
        return ResponseEntity.ok().body(listRoomService.listAll());
    }

    @Operation(summary = "Criar nova sala")
    @SecurityRequirement(name = "jwt_auth")
    @PostMapping("/")
    public ResponseEntity<RoomResponse> post(@RequestBody @Valid RoomRequest dto) {
        return ResponseEntity.ok().body(createRoomService.create(dto));
    }

    @DeleteMapping("/")
    public void delete(){
        
    }
    
}
