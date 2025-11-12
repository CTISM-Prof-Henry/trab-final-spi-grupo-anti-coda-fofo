package com.politecnico.poliagenda.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.politecnico.poliagenda.domain.Users;
import com.politecnico.poliagenda.domain.enums.Roles;
import com.politecnico.poliagenda.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class UserAdminConfig {

    private final PasswordEncoder passwordEncoder;

    @Value("${admin.email}")
    private String ADMIN_EMAIL;

    @Value("${admin.password}")
    private String ADMIN_PASSWORD;

    @Value("${admin.register}")
    private String ADMIN_REGISTER;

    @Bean
    @Transactional
    public CommandLineRunner initUser(UserRepository userRepository){
        return args -> {
            if(userRepository.findByEmail(ADMIN_EMAIL).isEmpty()){
                String encrypted = passwordEncoder.encode(ADMIN_PASSWORD);
                Users admin = Users.builder()
                    .email(ADMIN_EMAIL)
                    .password(encrypted)
                    .role(Roles.ROLE_ADMIN)
                    .register(ADMIN_REGISTER)
                    .build();
                userRepository.save(admin);
                System.out.println(ADMIN_EMAIL + " Usuario Cadastrado com sucesso! ");
            }
            else{
                System.out.println("Usuário adm já existente: " + ADMIN_EMAIL);
            }
        };
    }
}
