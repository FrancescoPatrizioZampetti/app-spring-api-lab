package com.blackphoenixproductions.appspringapilab.utente.repository;

import com.blackphoenixproductions.appspringapilab.utente.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUtenteRepository extends JpaRepository<Utente, Long> {

    Optional<Utente> findByUsername(String username);
    Optional<Utente> findByKeycloakId(String keycloakId);

}
