package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.PriceRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.TicketRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.PriceServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.TicketServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Price;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.ShowTime;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Ticket;

import jakarta.persistence.EntityManager;

@Service
public class PriceService implements PriceServiceInterface {

    // For Dependecy Injection
    private EntityManager entityManager;
    private PriceRepository priceRepo;
    private TicketRepository ticketRepo;

    // Constructor Injection
    @Autowired
    PriceService(EntityManager entityManager, PriceRepository priceRepo, TicketRepository ticketRepo) {
        this.entityManager = entityManager;
        this.priceRepo = priceRepo;
        this.ticketRepo = ticketRepo;
    }

    // Find all records from movies table.
    @Override
    public List<Price> findAll() {
        // Create empty Price List object.
        List<Price> priceList = new ArrayList<Price>();

        priceList = priceRepo.findAll();

        return priceList;
    }

    // Find one specific price from theaters table.
    @Override
    public Price findById(int id) {

        Price price = new Price();

        price = (Price) entityManager.createQuery("FROM Price WHERE id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();

        return price;
    }

    // Create or Update record to prices table.
    @Override
    public void save(Price price) {
        priceRepo.save(price);
    }

    // Delete one record from prices table.
    @Override
    public void delete(int id) {

        Price price = new Price();
        List<Ticket> ticketList = new ArrayList<Ticket>();

        // Create a query to get specific pirce record and type cast it to Price.
        price = (Price) entityManager.createQuery("FROM Price WHERE id LIKE :id")
                .setParameter("id", id).getSingleResult();

        // Retrive all the tickets from database.
        ticketList = ticketRepo.findAll();

        /*
         * Through for-each looping, find and delete if there're
         * tickets whose prices are equal to the price that we
         * want to delete. ( To resolve FK Constraint ).
         */
        for (Ticket ticket : ticketList) {
            if (ticket.getPrice() == price) {
                ticketRepo.delete(ticket);
            }
        }

        // Delete specific price record.
        priceRepo.delete(price);
    }
}
