package com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO;

import org.springframework.stereotype.Component;

import lombok.Data;

/*
 * DTO layer for ticket update request.
 */
@Data
@Component
public class TicketUpdateRequestDTO {

    private int id;
    private Integer movieId;
    private Integer theaterId;
    private Integer showTimeId;
    private Integer priceId;
}
