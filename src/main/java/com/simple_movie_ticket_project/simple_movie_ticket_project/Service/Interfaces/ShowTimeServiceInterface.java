package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces;

import java.util.List;

import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.ShowTime;

public interface ShowTimeServiceInterface {

    // Find all records from movies table.
    List<ShowTime> findAll();

    // Find one specific movie from movies table.
    ShowTime findById(int id);

    // Create or Update record to moves table.
    void save(ShowTime showTime);

    // Delete one record from moview table.
    void delete(int id);
}
