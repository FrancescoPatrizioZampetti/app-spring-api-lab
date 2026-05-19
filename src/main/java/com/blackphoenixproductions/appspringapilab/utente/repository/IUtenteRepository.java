package com.blackphoenixproductions.appspringapilab.utente.repository;

import com.blackphoenixproductions.appspringapilab.utente.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IUtenteRepository extends JpaRepository<Utente, Long> {

    Utente findByUsername(String username);
    Utente findByKeycloakId(Long keycloakId);

}
