package com.blackphoenixproductions.appspringapilab.shared.config.openapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configurazione per Swagger/OpenAPI.
 * Con il tasto Authorize permette di effettuare dei test chiamando keycloak OAuth2 come farebbe il front-end.
 */
@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME_NAME = "keycloak-oauth2";

    @Value("${app.security.oauth2.authorization-url}")
    private String authorizationUrl;

    @Value("${app.security.oauth2.token-url}")
    private String tokenUrl;

    @Bean
    OpenAPI appOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("app-spring-api-lab API")
                        .version("v1")
                        .description("API lab per autenticazione Keycloak in ambiente Azure"))
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME, keycloakOAuth2Scheme()))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME));
    }


    /**
     * Definisco tipo auth di keycloak, ovvero OAuth2 con authorization code flow
     * @return
     */
    private SecurityScheme keycloakOAuth2Scheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.OAUTH2)
                .flows(new OAuthFlows()
                        .authorizationCode(new OAuthFlow()
                                .authorizationUrl(authorizationUrl)
                                .tokenUrl(tokenUrl)
                                .scopes(new Scopes()
                                        .addString("openid", "OpenID")
                                        .addString("profile", "Profile")
                                        .addString("email", "Email"))));
    }
}