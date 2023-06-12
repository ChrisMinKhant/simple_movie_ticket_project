package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces;

import java.util.List;

import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Theater;

public interface TheaterServiceInterface {

    // Find all records from movies table.
    List<Theater> findAll();

    // Find one specific movie from movies table.
    Theater findById(int id);

    // Create or Update record to moves table.
    void save(Theater theater);

    // Delete one record from moview table.
    void delete(int id);
}
