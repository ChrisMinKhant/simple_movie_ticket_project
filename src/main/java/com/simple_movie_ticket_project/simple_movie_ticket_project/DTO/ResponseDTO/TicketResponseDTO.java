package com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.ResponseDTO;

import org.springframework.stereotype.Component;

import lombok.Data;

/*
 * DTO layer for ticket response.
 * Exposing only Movie Name, Theater Name,
 * Show Time, and Price.
 */
@Component
@Data
public class TicketResponseDTO {

    private String movie;
    private String theater;
    private String showTime;
    private String price;
}
