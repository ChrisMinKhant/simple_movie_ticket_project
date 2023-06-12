package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces;

import java.util.List;

import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Movie;

public interface MovieServiceInterface {

    // Find all records from movies table.
    List<Movie> findAll();

    // Find one specific movie from movies table.
    Movie findById(int id);

    // Create or Update record to moves table.
    void save(Movie movie);

    // Delete one record from moview table.
    void delete(int id);
}
