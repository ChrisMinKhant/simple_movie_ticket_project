package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces;

import java.util.List;

import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO.TicketRequestDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.ResponseDTO.TicketResponseDTO;

/*
 * Interface for ticket service
 */
public interface TicketServiceInterface {

    // Find all tickets.
    List<TicketResponseDTO> findAll();

    // Find record by its id.
    TicketResponseDTO findById(int id);

    // Save new ticket.
    void saveTicket(TicketRequestDTO ticketRequestDTO);

    // Update existing ticket.
    void updateTicket(TicketRequestDTO ticketRequestDTO, int id);

    // Delete record.
    void delete(int id);
}
