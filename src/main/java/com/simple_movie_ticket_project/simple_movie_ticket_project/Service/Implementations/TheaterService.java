package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.TheaterRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.TicketRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.TheaterServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Theater;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Ticket;

import jakarta.persistence.EntityManager;

@Service
public class TheaterService implements TheaterServiceInterface {

    // For Dependency Injection
    private TheaterRepository theaterRepo;
    private EntityManager entityManager;
    private TicketRepository ticketRepo;

    // Constructor Injection
    TheaterService(TheaterRepository theaterRepo, EntityManager entityManager, TicketRepository ticketRepo) {
        this.theaterRepo = theaterRepo;
        this.entityManager = entityManager;
        this.ticketRepo = ticketRepo;
    }

    // Find all records from theaters table.
    @Override
    public List<Theater> findAll() {
        // Create empty Ticket List object.
        List<Theater> theaterList = new ArrayList<Theater>();

        theaterList = theaterRepo.findAll();

        return theaterList;
    }

    // Find one specific movie from theaters table.
    @Override
    public Theater findById(int id) {
        Theater theater = new Theater();

        theater = (Theater) entityManager.createQuery("FROM Theater WHERE id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();

        return theater;
    }

    // Create or Update record to theaters table.
    @Override
    public void save(Theater theater) {
        theaterRepo.save(theater);
    }

    // Delete one record from theaters table.
    @Override
    public void delete(int id) {

        Theater theater = new Theater();
        List<Ticket> ticketList = new ArrayList<Ticket>();

        // Create a query to get specific theater record and type cast it to Theater.
        theater = (Theater) entityManager.createQuery("FROM Theater WHERE id LIKE :id")
                .setParameter("id", id).getSingleResult();

        // Retrive all the tickets from database.
        ticketList = ticketRepo.findAll();

        /*
         * Through for-each looping, find and delete if there're
         * tickets whose theaters are equal to the theater that we
         * want to delete. ( To resolve FK Constraint ).
         */
        for (Ticket ticket : ticketList) {
            if (ticket.getTheater() == theater) {
                ticketRepo.delete(ticket);
            }
        }

        // Delete specific user record.
        theaterRepo.delete(theater);
    }
}
