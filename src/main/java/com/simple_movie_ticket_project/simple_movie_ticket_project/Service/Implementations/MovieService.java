package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.MovieRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.TicketRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.MovieServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Movie;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Ticket;

import jakarta.persistence.EntityManager;

/*
 * Service layer for movie.
 */
@Service
public class MovieService implements MovieServiceInterface {

    // For Dependency Injection
    private MovieRepository movieRepo;
    private EntityManager entityManager;
    private TicketRepository ticketRepo;

    // Constructor Injection
    MovieService(MovieRepository movieRepo, EntityManager entityManager, TicketRepository ticketRepo) {
        this.movieRepo = movieRepo;
        this.entityManager = entityManager;
        this.ticketRepo = ticketRepo;
    }

    // Find all records from movies table.
    @Override
    public List<Movie> findAll() {
        // Create empty Movie List object.
        List<Movie> movieList = new ArrayList<Movie>();

        movieList = movieRepo.findAll();

        return movieList;
    }

    // Find one specific movie from movies table.
    @Override
    public Movie findById(int id) {

        Movie movie = new Movie();

        movie = (Movie) entityManager.createQuery("FROM Movie WHERE id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();

        return movie;
    }

    // Create or Update record to movies table.
    @Override
    public void save(Movie movie) {
        movieRepo.save(movie);
    }

    // Delete one record from movies table.
    @Override
    public void delete(int id) {

        Movie movie = new Movie();
        List<Ticket> ticketList = new ArrayList<Ticket>();

        // Create a query to get specific movie record and type cast it to Movie.
        movie = (Movie) entityManager.createQuery("FROM Movie WHERE id LIKE :id")
                .setParameter("id", id).getSingleResult();

        // Retrive all the tickets from database.
        ticketList = ticketRepo.findAll();

        /*
         * Through for-each looping, find and delete if there're
         * tickets whose movies are equal to the movie that we
         * want to delete. ( To resolve FK Constraint ).
         */
        for (Ticket ticket : ticketList) {
            if (ticket.getMovie() == movie) {
                ticketRepo.delete(ticket);
            }
        }

        // Delete specific user record.
        movieRepo.delete(movie);
    }
}
