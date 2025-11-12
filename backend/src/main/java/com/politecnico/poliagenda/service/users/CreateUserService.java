package com.politecnico.poliagenda.service.users;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.politecnico.poliagenda.controller.request.CreatedUserRequest;
import com.politecnico.poliagenda.controller.response.UserResponse;
import com.politecnico.poliagenda.domain.Users;
import com.politecnico.poliagenda.domain.enums.Roles;
import com.politecnico.poliagenda.mapper.UserMapper;
import com.politecnico.poliagenda.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //método destinado apenas a criar professor
    public UserResponse create(CreatedUserRequest request){
        Users newUser = UserMapper.toDomain(request);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setRole(Roles.ROLE_PROFESSOR);
        return UserMapper.toResponse(userRepository.save(newUser));
    }
}
