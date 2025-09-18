package com.ufsm.politecnico.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ufsm.politecnico.model.Admin;
import com.ufsm.politecnico.service.AdminService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    //injeta dependencia do service
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }

    //buscar por email
    @GetMapping("{email}")
    public ResponseEntity<Admin> getByemail(@PathVariable String email) {
        Admin a = adminService.getByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }

    //alterar o admin
    @PutMapping
    public ResponseEntity<Admin> editar(@Valid @RequestBody Admin admin) {
        Admin a = adminService.edit(admin);
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
}
