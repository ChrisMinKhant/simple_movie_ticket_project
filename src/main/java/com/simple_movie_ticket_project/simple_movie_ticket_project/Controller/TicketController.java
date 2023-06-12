package com.simple_movie_ticket_project.simple_movie_ticket_project.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO.TicketRequestDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.ResponseDTO.TicketResponseDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.TicketServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Ticket;

@RestController
@RequestMapping("/api")
public class TicketController {

    // For Dependency Injection
    private TicketServiceInterface ticketService;

    // Constructor Injection
    @Autowired
    TicketController(TicketServiceInterface ticketService) {
        this.ticketService = ticketService;
    }

    /*
     * Methods for GET::"/tickets" end point.
     */
    @GetMapping("/tickets")
    public List<TicketResponseDTO> getAllTickets() {

        // Create empty Ticket List object.
        List<TicketResponseDTO> ticketList = new ArrayList<TicketResponseDTO>();

        ticketList = ticketService.findAll();

        return ticketList;
    }

    /*
     * Methods for GET::"/tickets/{id}" end point.
     */
    @GetMapping("/tickets/{id}")
    public TicketResponseDTO getTicketById(@PathVariable int id) {

        // Create empty Ticket object.
        TicketResponseDTO ticket = new TicketResponseDTO();

        ticket = ticketService.findById(id);

        return ticket;
    }

    /*
     * Method for POST:"/tickets" end point.
     */
    @PostMapping("/tickets")
    public void createTicket(@RequestBody TicketRequestDTO ticketRequestDTO) {

        ticketService.saveTicket(ticketRequestDTO);

    }

    /*
     * Method for PUT:"/tickets" end point.
     */
    @PutMapping("/tickets")
    public void updateTicket(@RequestBody TicketRequestDTO ticketRequestDTO) {

        ticketService.saveTicket(ticketRequestDTO);

    }

    /*
     * Methods for DELETE::"/tickets/{id}" end point.
     */
    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable int id) {

        ticketService.delete(id);

    }
}
