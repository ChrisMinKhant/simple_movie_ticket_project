package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.ShowTimeRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.TicketRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.ShowTimeServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.ShowTime;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Ticket;

import jakarta.persistence.EntityManager;

@Service
public class ShowTimeService implements ShowTimeServiceInterface {

    // For Dependecy Injection
    private EntityManager entityManager;
    private ShowTimeRepository showTimeRepo;
    private TicketRepository ticketRepo;

    // Constructor Injection
    @Autowired
    ShowTimeService(EntityManager entityManager, ShowTimeRepository showTimeRpo, TicketRepository ticketRepo) {
        this.entityManager = entityManager;
        this.showTimeRepo = showTimeRpo;
        this.ticketRepo = ticketRepo;
    }

    // Find all records from movies table.
    @Override
    public List<ShowTime> findAll() {
        // Create empty ShowTime List object.
        List<ShowTime> showTimeList = new ArrayList<ShowTime>();

        showTimeList = showTimeRepo.findAll();

        return showTimeList;
    }

    // Find one specific movie from show_times table.
    @Override
    public ShowTime findById(int id) {

        ShowTime showTime = new ShowTime();

        showTime = (ShowTime) entityManager.createQuery("FROM ShowTime WHERE id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();

        return showTime;
    }

    // Create or Update record to show_times table.
    @Override
    public void save(ShowTime showTime) {
        showTimeRepo.save(showTime);
    }

    // Delete one record from show_times table.
    @Override
    public void delete(int id) {

        ShowTime showTime = new ShowTime();
        List<Ticket> ticketList = new ArrayList<Ticket>();

        // Create a query to get specific show_times record and type cast it to
        // ShowTime.
        showTime = (ShowTime) entityManager.createQuery("FROM ShowTime WHERE id LIKE :id")
                .setParameter("id", id).getSingleResult();

        // Retrive all the tickets from database.
        ticketList = ticketRepo.findAll();

        /*
         * Through for-each looping, find and delete if there're
         * tickets whose showTimes are equal to the showTime that we
         * want to delete. ( To resolve FK Constraint ).
         */
        for (Ticket ticket : ticketList) {
            if (ticket.getShowTime() == showTime) {
                ticketRepo.delete(ticket);
            }
        }

        // Delete specific user record.
        showTimeRepo.delete(showTime);
    }
}
