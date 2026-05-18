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
        logger.info("Start creaUtente");
        Utente nuovoUtente = new Utente(
                request.getEmail(),
                request.getUsername()
        );

        Utente savedUtente = utenteRepository.save(nuovoUtente);

        UtenteResponse response = new UtenteResponse(
                savedUtente.getUsername(),
                savedUtente.getEmail()
        );
        logger.info("End creaUtente");
        return response;
    }
}
