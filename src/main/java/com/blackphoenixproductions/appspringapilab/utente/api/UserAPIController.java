package com.blackphoenixproductions.appspringapilab.utente.api;

import com.blackphoenixproductions.appspringapilab.shared.dto.CreaUtenteRequest;
import com.blackphoenixproductions.appspringapilab.shared.dto.UtenteResponse;
import com.blackphoenixproductions.appspringapilab.utente.service.UtenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/utente")
@Tag(name = "1. Utente", description = "Endpoints riguardanti la gestione degli utenti.")
public class UserAPIController {

    private static final Logger logger = LoggerFactory.getLogger(UserAPIController.class);

    private final UtenteService utenteService;

    @Autowired
    public UserAPIController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @Operation(summary = "Restituisce l'utente loggato.")
    @GetMapping(value = "/recupera")
    public UtenteResponse recuperaUtente (HttpServletRequest req){
        logger.info("Start recuperaUtente");
        UtenteResponse utente = new UtenteResponse("test","test");
        logger.info("End recuperaUtente");
        return utente;
    }


    /**
     * Alla prima chiamata autenticata, viene creato un utente se non esiste.
     * @param request
     * @return
     */
    @Operation(summary = "Crea un utente se non esiste oppure lo aggiorna.")
    @PostMapping(value = "/aggiorna")
    public ResponseEntity<UtenteResponse> aggiornaUtente(@Valid @RequestBody CreaUtenteRequest request) {
        logger.info("Start aggiornaUtente");
        UtenteResponse utenteResp = utenteService.aggiornaUtente(request);
        // todo ritorna created se non esiste, ok se esiste
        logger.info("End aggiornaUtente");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(utenteResp);
    }


}
