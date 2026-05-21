package com.blackphoenixproductions.appspringapilab.utente.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/documenti")
@Tag(name = "2. Documenti", description = "Endpoints riguardanti la gestione dei documenti.")
public class DocumentiAPIController {

    @Operation(summary = "Recupera documento")
    @GetMapping(value = "/test")
    public ResponseEntity recuperaDocumento(Authentication authentication){
        return ResponseEntity.ok().build();
    }

}
