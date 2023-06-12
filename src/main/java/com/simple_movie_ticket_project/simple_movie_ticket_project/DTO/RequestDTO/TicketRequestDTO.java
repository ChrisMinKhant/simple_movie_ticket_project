package com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO;

import org.springframework.stereotype.Component;

import lombok.Data;

/*
 * DTO layer for Ticket Request
 * which way helps mapping the Ticket Entity to
 * necessary entities.
 */
@Component
@Data
public class TicketRequestDTO {

    private Integer movieId;
    private Integer theaterId;
    private Integer showTimeId;
    private Integer priceId;
}
