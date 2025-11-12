package com.politecnico.poliagenda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
        .info(new Info()
            .title("PoliAgenda API")
            .description("API para o sistema de agendamento poli")
            .version("1.0.0")
            .contact(getContact())
        )
        .schemaRequirement("jwt_auth", securityScheme());
    }

    private SecurityScheme securityScheme(){
        return new SecurityScheme()
            .name("jwt_auth")
            .scheme("bearer")
            .type(SecurityScheme.Type.HTTP)
            .in(SecurityScheme.In.HEADER);
    }

    private Contact getContact(){
        return new Contact()
            .email("jonassilvadelara@gmail.com")
            .name("jonas")
            .url("https://github.com/Jonas-SLara");
    }
}
