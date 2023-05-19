package com.sopt.wokat.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;


import org.springframework.context.annotation.*;
import org.springframework.http.HttpHeaders;

@Configuration

public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        Info info = new Info() 
                .title("✨WOKAT Swagger✨") 
                .version("v1.0.0") 
                .description("SOPT - WOKAT SERVER ") 
                .contact(new Contact().name("WOKAT Github")
                .url("https://github.com/Maro-SOPT/server"));

         // Security 스키마 설정
        SecurityScheme bearerAuth = new SecurityScheme() 
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .name(HttpHeaders.AUTHORIZATION);
     
         // Security 요청 설정
        SecurityRequirement addSecurityItem = new SecurityRequirement();
        addSecurityItem.addList("JWT");

        return new OpenAPI()
                // Security 인증 컴포넌트 설정
                .components(new Components().addSecuritySchemes("JWT", bearerAuth))
                // API 마다 Security 인증 컴포넌트 설정
                .addSecurityItem(addSecurityItem);  
    }

}