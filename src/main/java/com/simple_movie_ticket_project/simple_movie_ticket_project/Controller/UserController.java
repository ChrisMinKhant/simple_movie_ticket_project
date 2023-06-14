package com.simple_movie_ticket_project.simple_movie_ticket_project.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO.UserCreateRequestDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO.UserUpdateRequestDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.ResponseDTO.UserResponseDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.UserServiceInterface;

@RestController
@RequestMapping("/api")
public class UserController {

    // For Dependency Injection.
    private UserServiceInterface userService;

    // Counstructor Injection.
    @Autowired
    UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    // Method for GET::"/users" endpoint.
    // get all the users from the users table.
    @GetMapping("/users")
    public List<UserResponseDTO> getAllUsers() {

        // Create empty UserResponseDTO List object.
        List<UserResponseDTO> user = new ArrayList<UserResponseDTO>();

        user = userService.findAll();

        return user;
    }

    // Method for GET::"/users/{email}" endpoint.
    // get one specific user from the users table.
    @GetMapping("/users/{email}")
    public UserResponseDTO getUserByEmail(@PathVariable String email) {

        // Create empty UserResponseDTO object.
        UserResponseDTO user = new UserResponseDTO();

        user = userService.findByEmail(email);

        return user;
    }

    // Method for POST::"/users" endpoint.
    // save new user to the users table.
    @PostMapping("/users")
    public void saveNewUser(@RequestBody UserCreateRequestDTO user) {

        userService.save(user);

    }

    // Method for PUT::"/users" endpoint.
    // update existing user to the users table.
    @PutMapping("/users")
    public void updateUser(@RequestBody UserUpdateRequestDTO user) {

        userService.update(user);

    }

    // Method for DELETE::"/users/{email}" endpoint.
    // delete existing user to the users table.
    @DeleteMapping("/users/{email}")
    public void deleteUSer(@PathVariable String email) {

        userService.delete(email);

    }
}
