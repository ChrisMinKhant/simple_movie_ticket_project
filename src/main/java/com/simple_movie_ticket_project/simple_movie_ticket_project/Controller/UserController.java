package com.simple_movie_ticket_project.simple_movie_ticket_project.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.UserServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.User;

@RestController
@RequestMapping("/api")
public class UserController {

    // For Dependency Injection.
    private UserServiceInterface userService;

    // Counstructor Injection.
    UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    // Method for GET::"/users" endpoint.
    // get all the users from the users table.
    @GetMapping("/users")
    public List<User> getAllUsers() {

        // Create empty User List object.
        List<User> user = new ArrayList<User>();

        user = userService.findAll();

        return user;
    }

    // Method for GET::"/users" endpoint.
    // get one specific user from the users table.
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {

        // Create empty User object.
        User user = new User();

        user = userService.findById(id);

        return user;
    }

    // Method for POST::"/users" endpoint.
    // save new user to the users table.
    @PostMapping("/users")
    public void saveNewUser(@RequestBody User user) {

        userService.save(user);

    }

    // Method for PUT::"/users" endpoint.
    // update existing user to the users table.
    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {

        userService.save(user);

    }

    // Method for DELETE::"/users/{id}" endpoint.
    // delete existing user to the users table.
    @DeleteMapping("/users/{id}")
    public void deleteUSer(@PathVariable int id) {

        userService.delete(id);

    }
}
