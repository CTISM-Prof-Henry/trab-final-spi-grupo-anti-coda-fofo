package com.politecnico.poliagenda.service;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.politecnico.poliagenda.controller.request.AuthRequest;
import com.politecnico.poliagenda.controller.response.AuthResponse;
import com.politecnico.poliagenda.domain.Users;
import com.politecnico.poliagenda.repository.UserRepository;

import com.politecnico.poliagenda.handler.AuthException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    private boolean isValidPassword(String rawpassword, String encodedpassword){
        return passwordEncoder.matches(rawpassword, encodedpassword);
    }
    
    private String generateToken(Users user){
        JwtClaimsSet clains = JwtClaimsSet.builder()
            .issuer("poliagenda-api")
            .issuedAt(Instant.now())
            .expiresAt(Instant.now().plusSeconds(jwtExpiration))
            .subject(user.getUuid().toString())
            .claim("register", user.getRegister())
            .claim("role", user.getRole().name())
            .claim("email", user.getEmail())
            .build();

        JwsHeader jwsHeader = JwsHeader
            .with(() -> "HS256")
            .build();
                
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader,clains)).getTokenValue();
    }

    public AuthResponse authenticate(AuthRequest request) {
        Optional<Users> user = userRepository.findByEmail(request.getEmail());
        if(!user.isPresent()) throw new AuthException("Usuário ou senha incorretos");

        if (!isValidPassword(request.getPassword(), user.get().getPassword())) {
            System.out.println("\nsenha inválida\n");
            throw new AuthException("Usuário ou senha incorretos");
        }

        String accessToken = generateToken(user.get());
        
        return AuthResponse.builder()
                .accessToken(accessToken)
                .expiresIn(jwtExpiration)
                .build();
    }
}
