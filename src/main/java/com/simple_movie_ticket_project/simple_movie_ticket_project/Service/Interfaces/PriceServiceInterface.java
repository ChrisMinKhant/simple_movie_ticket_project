package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces;

import java.util.List;

import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Price;

public interface PriceServiceInterface {

    // Find all records from movies table.
    List<Price> findAll();

    // Find one specific movie from movies table.
    Price findById(int id);

    // Create or Update record to moves table.
    void save(Price movie);

    // Delete one record from moview table.
    void delete(int id);

}
