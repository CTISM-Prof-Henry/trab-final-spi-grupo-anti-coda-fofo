package com.ufsm.politecnico.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class TokenServiceJWT{

    @Value("${api.security.token.secret}")
    private String secret;
    private static String ISSUER = "API POLI AGENDA";

    public String gerarToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
            .withIssuer(ISSUER)
            .withSubject(user.getUsername())
            .withExpiresAt(dataExpiracao())
            .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("erro ao criar token: " + e);
        }
    }

    //1 hora de expiração
    private Instant dataExpiracao(){
        LocalDateTime fim = LocalDateTime.now().plusHours(1);
        return fim.toInstant(ZoneOffset.of("-03:00"));
    }

    //verificar se tal token é válido
    public String validaToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                .withIssuer(ISSUER)
                .build()
                .verify(token)
                .getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("erro ao validar token: " + e);
        }
    }
}
