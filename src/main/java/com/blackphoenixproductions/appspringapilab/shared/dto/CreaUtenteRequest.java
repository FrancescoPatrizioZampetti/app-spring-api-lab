package com.blackphoenixproductions.appspringapilab.shared.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreaUtenteRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String email;
}
