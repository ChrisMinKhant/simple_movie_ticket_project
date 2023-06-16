package com.simple_movie_ticket_project.simple_movie_ticket_project.ExceptionHandler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.ResponseDTO.ApiErrorResponseDTO;

import jakarta.persistence.NoResultException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    // NoResultException Handler
    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<Object> noResultExceptionHandler(NoResultException exception) {

        // Tailor custom error message.
        String errorMessage = "Sorry, there's no the user your're finding.";

        // Create ApiErrorResponse object with necessary data.
        ApiErrorResponseDTO apiErrorResponse = new ApiErrorResponseDTO(HttpStatus.NOT_FOUND, errorMessage,
                exception.getLocalizedMessage());

        // return ResponseEntity object.
        return buildResponseEntity(apiErrorResponse);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiErrorResponseDTO apiErrorResponseDTO) {

        return new ResponseEntity<>(apiErrorResponseDTO, apiErrorResponseDTO.getStatus());
    }
}
