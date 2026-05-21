package com.blackphoenixproductions.appspringapilab.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtenteDTO {

    private String username;
    private String email;
    private String keycloakId;
    private String nome;
    private String cognome;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public UtenteDTO(String username,
                     String email,
                     String keycloakId,
                     String nome,
                     String cognome) {
        this.username = username;
        this.email = email;
        this.keycloakId = keycloakId;
        this.nome = nome;
        this.cognome = cognome;
    }

    public UtenteDTO(String username,
                     String email,
                     String nome,
                     String cognome) {
        this.username = username;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
    }
}
