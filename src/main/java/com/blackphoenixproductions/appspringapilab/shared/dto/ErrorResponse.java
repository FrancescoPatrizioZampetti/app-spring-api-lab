package com.blackphoenixproductions.appspringapilab.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String errorMessage;
    private HttpStatus status;
}