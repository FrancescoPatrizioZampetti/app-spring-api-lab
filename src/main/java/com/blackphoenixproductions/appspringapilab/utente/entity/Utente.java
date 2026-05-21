package com.blackphoenixproductions.appspringapilab.utente.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UTENTI")
@NoArgsConstructor
@Getter
@Setter
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String keycloakId;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column
    private String nome;

    @Column
    private String cognome;

    public Utente(String keycloakId, String username, String email, String nome, String cognome) {
        this.keycloakId = keycloakId;
        this.username = username;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
    }
}
