package com.blackphoenixproductions.appspringapilab.utente.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UTENTI_APP")
@NoArgsConstructor
@Getter
@Setter
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long keycloakId; // vera chiave sempre not null

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    public Utente(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
