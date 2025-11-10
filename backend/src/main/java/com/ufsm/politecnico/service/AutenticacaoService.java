package com.ufsm.politecnico.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ufsm.politecnico.model.Usuario;
import com.ufsm.politecnico.repositories.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService{
    
    private final UsuarioRepository usuarioRepository;

    public AutenticacaoService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> u = usuarioRepository.findByEmail(email);
        if(!u.isPresent()){
            throw new UsernameNotFoundException("email:" + email + " não achado");
        }
        UserDetails user = User.withUsername(email)
            .password(u.get().getPassword())
            .authorities(u.get().getAuthorities())
            .build();
        return user;
    }
}
