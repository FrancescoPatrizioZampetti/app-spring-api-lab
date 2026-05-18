package com.blackphoenixproductions.appspringapilab.shared.config.openapi;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {


    @Bean
    OpenAPI appOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("app-spring-api-lab API")
                        .version("v1")
                        .description("API lab per autenticazione Keycloak in ambiente Azure"))
                .components(new Components()
                        .addSecuritySchemes("bearer-jwt", // aggiunge pulsante per autenticazione per mettere il jwt Bearer
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }

}
