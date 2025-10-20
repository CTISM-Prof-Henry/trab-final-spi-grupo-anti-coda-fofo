package com.ufsm.politecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufsm.politecnico.model.Usuario;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
}
