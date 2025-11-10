package com.ufsm.politecnico.security;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ufsm.politecnico.service.AutenticacaoService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenServiceJWT tokenService;
    private final AutenticacaoService autenticacaoService;

    public SecurityFilter(TokenServiceJWT tokenService, AutenticacaoService autenticacaoService){
        this.tokenService = tokenService;
        this.autenticacaoService = autenticacaoService;
    }  

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = this.recoveryToken(request);

        //caso tenha o token recuperar email e achar o usuario
        if(token != null){
            try{
                String subject = tokenService.validaToken(token);
                //se for válido guarda no contexto
                UserDetails usuario = autenticacaoService.loadUserByUsername(subject);
                UsernamePasswordAuthenticationToken aut = 
                new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(aut);
            }
            catch(RuntimeException ex){
                //token invalido limpa o contexto
                SecurityContextHolder.clearContext();
                System.out.println("Token inválido: " + ex.getMessage());
            }
        }
        //caso não passe para o próximo filtro
        filterChain.doFilter(request, response);
    }

    // função auxiliar para capturar as requisições que chegarem na web
    private String recoveryToken(HttpServletRequest request){
        String autHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(autHeader == null) return null;
        //remove o prefixo e deixa apenas o token
        return autHeader.replace("Bearer", "").trim();
    }
}
