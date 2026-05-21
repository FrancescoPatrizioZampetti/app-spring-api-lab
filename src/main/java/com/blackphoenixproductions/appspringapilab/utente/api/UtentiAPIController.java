package com.blackphoenixproductions.appspringapilab.utente.api;

import com.blackphoenixproductions.appspringapilab.shared.dto.CreaUtenteRequest;
import com.blackphoenixproductions.appspringapilab.shared.dto.UtenteDTO;
import com.blackphoenixproductions.appspringapilab.shared.utils.SecurityUtils;
import com.blackphoenixproductions.appspringapilab.utente.service.UtenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utenti")
@Tag(name = "1. Utente", description = "Endpoints riguardanti la gestione degli utenti.")
public class UtentiAPIController {

    private static final Logger logger = LoggerFactory.getLogger(UtentiAPIController.class);

    private final UtenteService utenteService;

    @Autowired
    public UtentiAPIController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @Operation(summary = "Restituisce l'utente loggato.")
    @GetMapping(value = "/recupera")
    public UtenteDTO recuperaUtente (Authentication authentication){
        logger.info("Start recuperaUtente");

        String keycloakId = SecurityUtils.getKeycloakId(authentication);
        String username = SecurityUtils.getUsername(authentication);
        String email = SecurityUtils.getEmail(authentication);
        List<String> roles = SecurityUtils.getRoles(authentication);

        logger.info("Utente loggato: {}", username);
        logger.info("Email: {}", email);
        logger.info("KeycloakId: {}", keycloakId);
        logger.info("Roles: {}", roles);

        UtenteDTO utenteDTO = new UtenteDTO(
                username,
                email,
                keycloakId,
                null,
                null
        );
        logger.info("End recuperaUtente");
        return utenteDTO;
    }


    /**
     * Alla prima chiamata autenticata, viene creato un utente se non esiste.
     * @param request
     * @return
     */
    @Operation(summary = "Crea un utente se non esiste oppure lo aggiorna.")
    @PostMapping(value = "/aggiorna")
    public UtenteDTO aggiornaUtente(Authentication authentication,
                                    @Valid @RequestBody CreaUtenteRequest request) {
        logger.info("Start aggiornaUtente");

        String keycloakId = SecurityUtils.getKeycloakId(authentication);
        String username = SecurityUtils.getUsername(authentication);
        String email = SecurityUtils.getEmail(authentication);
        UtenteDTO utenteDTO = new UtenteDTO(
                username,
                email,
                keycloakId,
                request.getNome(),
                request.getCognome()
        );
        UtenteDTO utenteResp = utenteService.aggiornaUtente(utenteDTO);
        logger.info("End aggiornaUtente");
        return utenteResp;
    }


}
