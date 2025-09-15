package com.ufsm.politecnico.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ufsm.politecnico.model.Admin;
import com.ufsm.politecnico.service.AdminService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    //injeta dependencia do service
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Admin>> lista() {
        List<Admin> dados = adminService.listar();
        return ResponseEntity.ok(dados);
    }

    @PostMapping("/")
    public  ResponseEntity<Admin> save(@Valid @RequestBody Admin admin) {
        Admin adm = adminService.saveAdmin(admin);
        return ResponseEntity.status(201).body(adm);
    }
    
    
}
