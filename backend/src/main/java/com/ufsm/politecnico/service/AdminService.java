package com.ufsm.politecnico.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ufsm.politecnico.model.Admin;
import com.ufsm.politecnico.repositories.AdminRepository;

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

    public Admin saveAdmin(Admin a){
        return adminRepository.save(a);
    }

    public Admin deletAdmin(UUID uuid){
        Optional<Admin> a = adminRepository.findById(uuid);
        //se houver um, deletar
        if(a.isPresent()){
            adminRepository.deleteById(uuid);
            return a.get();
        }
        //lança exceção se não achar
        throw new NoSuchElementException();
    }

    public List<Admin> listar(){
        return adminRepository.findAll();
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
