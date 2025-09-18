package com.ufsm.politecnico.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ufsm.politecnico.model.Admin;
import com.ufsm.politecnico.repositories.AdminRepository;

/*
 * Sobre o admin, que será unico no sistema, logo
 * não será permitido cadastrar um novo e não haverá a
 * opção de listar todos, por segurança e sim apenas
 * achar o admin por email ou uuid e validar sua senha
*/

@Service
public class AdminService {

    private AdminRepository adminRepository;
    
    //@Autowired
    public AdminService(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }

    public Admin getByUuid(UUID uuid){
        Optional<Admin> a  = adminRepository.findById(uuid);
        if(a.isPresent()) return a.get();
        //lança a exceção de recurso não encontrado caso não há
        throw new NoSuchElementException();
    }

    public Admin getByEmail(String email){
        Optional<Admin> a = adminRepository.findByEmail(email);
        if(a.isPresent()) return a.get();
        throw new NoSuchElementException();
    }

    public Admin edit(Admin a){
        Optional<Admin> antigo = adminRepository.findById(a.getUuid());
        if(antigo.isPresent()){
            //altera
            antigo.get().setEmail(a.getEmail());
            antigo.get().setSenha(a.getSenha());
            adminRepository.save(antigo.get());
            return antigo.get();
        }
        //lanca exceção
        throw new NoSuchElementException();
    }
}
