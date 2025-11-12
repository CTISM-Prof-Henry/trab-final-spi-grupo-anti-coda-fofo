package com.politecnico.poliagenda.service.users;

import java.util.List;

import org.springframework.stereotype.Service;

import com.politecnico.poliagenda.controller.response.UserResponse;
import com.politecnico.poliagenda.mapper.UserMapper;
import com.politecnico.poliagenda.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListUsers {

    private final UserRepository userRepository;

    public List<UserResponse> listUsers(){
        return userRepository.findAll()
            .stream()
            .map(u -> UserMapper.toResponse(u))
            .toList();
    }
}
