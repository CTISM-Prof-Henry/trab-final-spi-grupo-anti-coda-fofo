package com.politecnico.poliagenda.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.politecnico.poliagenda.domain.Users;
import java.util.Optional;


public interface UserRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByEmail(String email);
    
}
