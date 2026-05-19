package com.blackphoenixproductions.appspringapilab.utente.service;

import com.blackphoenixproductions.appspringapilab.shared.dto.CreaUtenteRequest;
import com.blackphoenixproductions.appspringapilab.shared.dto.UtenteResponse;
import com.blackphoenixproductions.appspringapilab.utente.entity.Utente;
import com.blackphoenixproductions.appspringapilab.utente.repository.IUtenteRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    private static final Logger logger = LoggerFactory.getLogger(UtenteService.class);

    private final IUtenteRepository utenteRepository;

    @Autowired
    public UtenteService(IUtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }


    public UtenteResponse aggiornaUtente(@Valid CreaUtenteRequest request) {
        logger.info("Start aggiornaUtente");

        Utente findedUtente = utenteRepository.findByKeycloakId(request.getKeycloakId());
        if (findedUtente == null) {
            logger.info("Creo utente - keykloack id: {}", request.getKeycloakId());
            Utente nuovoUtente = new Utente(
                    request.getEmail(),
                    request.getUsername()
            );
            findedUtente = utenteRepository.saveAndFlush(nuovoUtente);
        } else {
            if( !findedUtente.getEmail().equals(request.getEmail())
                    || !findedUtente.getUsername().equals(request.getUsername()) ){
                logger.info("Aggiorno utente - keykloack id: {}", findedUtente.getKeycloakId());
                findedUtente.setEmail(request.getEmail());
                findedUtente.setUsername(request.getUsername());
                findedUtente = utenteRepository.saveAndFlush(findedUtente);
            }
        }

        UtenteResponse response = new UtenteResponse(
                findedUtente.getUsername(),
                findedUtente.getEmail()
        );
        logger.info("End aggiornaUtente");
        return response;
    }
}
