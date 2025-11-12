package com.politecnico.poliagenda.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.politecnico.poliagenda.controller.response.UserResponse;
import com.politecnico.poliagenda.domain.Users;
import com.politecnico.poliagenda.mapper.UserMapper;
import com.politecnico.poliagenda.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticadedUserService {

    private final UserRepository userRepository;

    public Users get(){
        UUID uuid = getIdFromToken();
        Optional<Users> users = userRepository.findById(uuid);
        if(users.isEmpty()){
            throw new RuntimeException("usuario não autenticado ou cadastrado");
        }
        else{
            return users.get();
        }
    }

    public UserResponse getToResponse(){
        Users users = get();
        return UserMapper.toResponse(users);
    }

    private UUID getIdFromToken(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = (Jwt) auth.getCredentials();
        return UUID.fromString(jwt.getSubject());
    }
}
