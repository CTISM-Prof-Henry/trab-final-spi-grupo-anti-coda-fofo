package com.ufsm.politecnico.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ufsm.politecnico.dto.AdminDTO;
import com.ufsm.politecnico.service.AdminService;

import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    //injeta dependencia do service
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }

    //alterar o admin
    @PutMapping
    public ResponseEntity<Boolean> editar(@RequestParam UUID uuid, @Valid @RequestBody AdminDTO admin) {
        boolean status = adminService.edit(uuid, admin);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }

    //autenticar o admin
    @PostMapping("/login")
    public ResponseEntity<AdminDTO> postMethodName(
            @RequestParam String email,
            @RequestParam String senha){
        
        AdminDTO a = this.adminService.autentica(email, senha);

        return (a!=null)? 
        ResponseEntity.ok().body(a):
        ResponseEntity.notFound().build();
    }
    
}
