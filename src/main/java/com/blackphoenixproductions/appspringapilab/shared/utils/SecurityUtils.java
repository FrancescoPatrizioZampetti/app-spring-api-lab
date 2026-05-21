package com.blackphoenixproductions.appspringapilab.shared.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.List;

public class SecurityUtils {

    private SecurityUtils() {
    }

    public static String getKeycloakId(Authentication authentication) {
        JwtAuthenticationToken jwtAuthentication = (JwtAuthenticationToken) authentication;
        Jwt jwt = jwtAuthentication.getToken();
        return jwt.getSubject();
    }

    public static String getUsername(Authentication authentication) {
        JwtAuthenticationToken jwtAuthentication = (JwtAuthenticationToken) authentication;
        Jwt jwt = jwtAuthentication.getToken();
        return username(jwt);
    }


    public static String username(Jwt jwt) {
        String preferredUsername = jwt.getClaimAsString("preferred_username");
        if (StringUtils.isNotBlank(preferredUsername)) {
            return preferredUsername;
        }
        return jwt.getSubject();
    }

    public static String getEmail(Authentication authentication) {
        JwtAuthenticationToken jwtAuthentication = (JwtAuthenticationToken) authentication;
        Jwt jwt = jwtAuthentication.getToken();
        return jwt.getClaimAsString("email");
    }

    public static List<String> getRoles(Authentication authentication) {
        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
    }

}
