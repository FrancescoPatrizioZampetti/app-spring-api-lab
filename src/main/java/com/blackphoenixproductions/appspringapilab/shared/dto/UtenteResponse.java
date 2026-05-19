package com.blackphoenixproductions.appspringapilab.shared.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UtenteResponse {
    private String username;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public UtenteResponse(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
