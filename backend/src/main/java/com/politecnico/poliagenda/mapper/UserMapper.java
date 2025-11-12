package com.politecnico.poliagenda.mapper;

import com.politecnico.poliagenda.controller.request.CreatedUserRequest;
import com.politecnico.poliagenda.controller.response.UserResponse;
import com.politecnico.poliagenda.domain.Users;

public class UserMapper {

    public static Users toDomain(CreatedUserRequest request) {
        return Users.builder()
                .register(request.getRegister())
                .email(request.getEmail())
                .build();
    }

    public static UserResponse toResponse(Users user) {
        return UserResponse.builder()
                .id(user.getUuid())
                .register(user.getRegister())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}
