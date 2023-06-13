package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces;

import java.util.List;

import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO.RoleRequestDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Role;

public interface RoleServiceInterface {
    // Find all records from movies table.
    List<Role> findAll();

    // Find one specific movie from movies table.
    Role findById(int id);

    // Create or Update record to moves table.
    void save(RoleRequestDTO roleDto);

    // Delete one record from moview table.
    void delete(int id);
}
