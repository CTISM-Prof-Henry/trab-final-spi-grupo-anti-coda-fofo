package com.ufsm.politecnico.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufsm.politecnico.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID>{

    //achar o admin por email
    public Optional<Admin> findByEmail(String email);

    //achar o admin por uuid
    public Optional<Admin> findByUuid(UUID uuid);
}
