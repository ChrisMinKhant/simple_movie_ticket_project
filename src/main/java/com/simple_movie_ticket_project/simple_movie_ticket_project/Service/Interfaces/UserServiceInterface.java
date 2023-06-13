package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces;

import java.util.List;
import java.util.Optional;

import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO.UserCreateRequestDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO.UserUpdateRequestDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.ResponseDTO.UserResponseDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.User;

public interface UserServiceInterface {

    // Find all users.
    List<UserResponseDTO> findAll();

    // Find by email.
    UserResponseDTO findByEmail(String email);

    // Create new user.
    void save(UserCreateRequestDTO userCreateRequestDTO);

    // Update existing user record.
    void update(UserUpdateRequestDTO userUpdateRequestDTO);

    // Delete user data.
    void delete(String email);
}
