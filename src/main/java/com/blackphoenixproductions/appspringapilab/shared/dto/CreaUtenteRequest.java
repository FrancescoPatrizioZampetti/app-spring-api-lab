package com.blackphoenixproductions.appspringapilab.shared.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreaUtenteRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String cognome;
}
