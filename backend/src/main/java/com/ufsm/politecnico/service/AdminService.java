package com.ufsm.politecnico.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ufsm.politecnico.dto.AdminDTO;
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

    public AdminDTO getByUuid(UUID uuid){
        Optional<Admin> a  = adminRepository.findById(uuid);
        if(a.isPresent()) return new AdminDTO(
            a.get().getEmail(),
            a.get().getUuid()
        );
        //lança a exceção de recurso não encontrado caso não há
        throw new NoSuchElementException();
    }

    public AdminDTO autentica(String email, String senha){
        Optional<Admin> a = this.adminRepository.findByEmail(email);
        
        if(!a.isPresent()) return null;
        if(!a.get().getSenha().equals(senha)) return null;

        AdminDTO ad = new AdminDTO(a.get().getEmail(), a.get().getUuid());
        ad.setSenha(senha);
        return ad;
    }

    //altera apenas a senha
    public boolean edit(UUID uuid, AdminDTO novo){
        Optional<Admin> antigo = adminRepository.findById(uuid);
        if(antigo.isPresent()){
            antigo.get().setSenha(novo.getSenha());
            adminRepository.save(antigo.get());
            return true;
        }
        //lanca exceção
        throw new NoSuchElementException();
    }
}
