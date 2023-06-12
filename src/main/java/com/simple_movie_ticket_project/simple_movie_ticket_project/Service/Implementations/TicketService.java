package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO.TicketRequestDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.ResponseDTO.TicketResponseDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.TicketRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.MovieServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.PriceServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.ShowTimeServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.TheaterServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.TicketServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Movie;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Price;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.ShowTime;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Theater;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Ticket;

import jakarta.persistence.EntityManager;

@Service
public class TicketService implements TicketServiceInterface {

    // For Dependency Injection
    private TicketRepository ticketRepo;
    private MovieServiceInterface movieService;
    private TheaterServiceInterface theaterService;
    private PriceServiceInterface priceService;
    private ShowTimeServiceInterface showTimeService;
    private EntityManager entityManager;

    // Constructor Injection
    @Autowired
    TicketService(TicketRepository ticketRepo,
            MovieServiceInterface movieService,
            TheaterServiceInterface theaterService,
            PriceServiceInterface priceService,
            ShowTimeServiceInterface showTimeService,
            EntityManager entityManager) {

        this.ticketRepo = ticketRepo;
        this.movieService = movieService;
        this.theaterService = theaterService;
        this.showTimeService = showTimeService;
        this.priceService = priceService;
        this.entityManager = entityManager;

    }

    // Find all tickets.
    public List<TicketResponseDTO> findAll() {

        // Create empty Ticket List object.
        List<Ticket> ticketList = new ArrayList<Ticket>();

        // Create empty TicketResponseDTO List object.
        List<TicketResponseDTO> ticketResponseList = new ArrayList<TicketResponseDTO>();

        ticketList = ticketRepo.findAll();

        for (Ticket ticket : ticketList) {

            // Create temporary TicketResponseDTO object.
            TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();

            // Set Ticket data to TicketResponseDTO using setter.
            ticketResponseDTO.setMovie(ticket.getMovie().getTitle());
            ticketResponseDTO.setTheater(ticket.getTheater().getName());
            ticketResponseDTO.setShowTime(ticket.getShowTime().getTime());
            ticketResponseDTO.setPrice(ticket.getPrice().getPrice());

            // Add temporary TicketResponseDTO to TicketResponseDTO List.
            ticketResponseList.add(ticketResponseDTO);
        }

        // Return TicketResponseDTO List.
        return ticketResponseList;
    }

    // Find record by its id.
    public TicketResponseDTO findById(int id) {

        // Create empty Ticket object.
        Ticket ticket = new Ticket();

        // Retrive ticket record according to its id;
        ticket = (Ticket) entityManager.createQuery("FROM Ticket WHERE id LIKE :id")
                .setParameter("id", id).getSingleResult();

        // Create temporary TicketResponseDTO object.
        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();

        // Set Ticket data to TicketResponseDTO using setter.
        ticketResponseDTO.setMovie(ticket.getMovie().getTitle());
        ticketResponseDTO.setTheater(ticket.getTheater().getName());
        ticketResponseDTO.setShowTime(ticket.getShowTime().getTime());
        ticketResponseDTO.setPrice(ticket.getPrice().getPrice());

        // Return retrived ticket.
        return ticketResponseDTO;
    }

    // Save new tickets.
    public void saveTicket(TicketRequestDTO ticketRequestDTO) {

        // Create empty Ticket object.
        Ticket ticket = new Ticket();

        // Call requestedTicketFromDto method to get Ticket object with
        // associate data.
        ticket = this.requestedTicketFromDto(ticketRequestDTO);

        // Persist it to the database.
        ticketRepo.save(ticket);
    }

    // Delete record.
    public void delete(int id) {

        // Create empty Ticket object.
        Ticket ticket = new Ticket();

        // Retrive ticket record according to its id;
        ticket = (Ticket) entityManager.createQuery("FROM Ticket WHERE id LIKE :id")
                .setParameter("id", id).getSingleResult();

        // Delete Ticket from the database.
        ticketRepo.delete(ticket);
    }

    // Retrive necessary record and assign to the Ticket object.
    private Ticket requestedTicketFromDto(TicketRequestDTO ticketRequestDTO) {

        // Create Empty Object.
        Movie movie = new Movie();
        Theater theater = new Theater();
        ShowTime showTime = new ShowTime();
        Price price = new Price();

        // Retrive associate record from database by thier ids.
        movie = movieService.findById(ticketRequestDTO.getMovieId());
        theater = theaterService.findById(ticketRequestDTO.getTheaterId());
        showTime = showTimeService.findById(ticketRequestDTO.getShowTimeId());
        price = priceService.findById(ticketRequestDTO.getPriceId());

        // Assign all the associate entity objects to the Ticket object.
        Ticket ticket = new Ticket(movie, theater, showTime, price);

        // Return the Ticket object.
        return ticket;
    }
}
