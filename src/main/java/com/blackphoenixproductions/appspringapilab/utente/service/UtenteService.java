package com.blackphoenixproductions.appspringapilab.utente.service;

import com.blackphoenixproductions.appspringapilab.shared.dto.UtenteDTO;
import com.blackphoenixproductions.appspringapilab.utente.entity.Utente;
import com.blackphoenixproductions.appspringapilab.utente.repository.IUtenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UtenteService {

    private static final Logger logger = LoggerFactory.getLogger(UtenteService.class);

    private final IUtenteRepository utenteRepository;

    @Autowired
    public UtenteService(IUtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }


    public UtenteDTO aggiornaUtente(UtenteDTO utenteDTO) {
        Utente utente = utenteRepository.findByKeycloakId(utenteDTO.getKeycloakId());
        if (utente == null) {
            logger.info("Creo utente - keycloak id: {}", utenteDTO.getKeycloakId());
            Utente nuovoUtente = new Utente(
                    utenteDTO.getEmail(),
                    utenteDTO.getUsername(),
                    utenteDTO.getKeycloakId(),
                    utenteDTO.getNome(),
                    utenteDTO.getCognome()
            );
            utente = utenteRepository.saveAndFlush(nuovoUtente);
        } else {
            boolean changed =
                    !Objects.equals(utente.getEmail(), utenteDTO.getEmail())
                            || !Objects.equals(utente.getUsername(), utenteDTO.getUsername())
                            || !Objects.equals(utente.getNome(), utenteDTO.getNome())
                            || !Objects.equals(utente.getCognome(), utenteDTO.getCognome());

            if (changed) {
                logger.info("Aggiorno utente - keycloak id: {}", utente.getKeycloakId());
                utente.setEmail(utenteDTO.getEmail());
                utente.setUsername(utenteDTO.getUsername());
                utente.setNome(utenteDTO.getNome());
                utente.setCognome(utenteDTO.getCognome());
                utente = utenteRepository.saveAndFlush(utente);
            }
        }
        return new UtenteDTO(
                utente.getEmail(),
                utente.getUsername(),
                utente.getNome(),
                utente.getCognome()
        );
    }
}
