package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces;

import java.util.List;
import java.util.Optional;

import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.User;

public interface UserServiceInterface {

    // Find all users.
    List<User> findAll();

    // Find by id.
    User findById(int id);

    // Create or update new user.
    void save(User user);

    // Delete user data.
    void delete(int id);
}
