package com.blackphoenixproductions.appspringapilab.shared.dto;

import lombok.Data;

@Data
public class UtenteResponse {
    private String username;
    private String email;

    public UtenteResponse(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
