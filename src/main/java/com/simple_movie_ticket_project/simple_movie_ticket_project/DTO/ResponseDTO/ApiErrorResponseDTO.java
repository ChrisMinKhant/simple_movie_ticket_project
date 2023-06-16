package com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.ResponseDTO;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.Data;

/*
 * DTO layer for Api Exception Handling Report.
 */
@Component
@Data
public class ApiErrorResponseDTO {

    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;
    private String systemMessage;

    private ApiErrorResponseDTO() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiErrorResponseDTO(HttpStatus status, String message, String systemMessage) {
        this();
        this.status = status;
        this.message = message;
        this.systemMessage = systemMessage;
    }
}
