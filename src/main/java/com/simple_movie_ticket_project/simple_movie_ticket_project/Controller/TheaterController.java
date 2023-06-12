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

import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Implementations.TheaterService;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Theater;

@RestController
@RequestMapping("/api")
public class TheaterController {

    // For Dependency Injection
    private TheaterService theaterService;

    // Constructor Injection
    TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    // Method for GET::"/theaters" endpoint.
    // get all the theaters from the theaters table.
    @GetMapping("/theaters")
    public List<Theater> getAllTheaters() {

        // Create Empty Theater List Object.
        List<Theater> theater = new ArrayList<Theater>();

        theater = theaterService.findAll();
        return theater;
    }

    // Method for GET::"/theaters/{id}" endpoint.
    // get one specific theater from the theaters table.
    @GetMapping("/theaters/{id}")
    public Theater getTheaterById(@PathVariable int id) {

        // Create empty Theater object.
        Theater theater = new Theater();

        theater = theaterService.findById(id);

        return theater;
    }

    // Method for POST::"/theaters" endpoint.
    // save new theater to the theaters table.
    @PostMapping("/theaters")
    public void saveNewTheater(@RequestBody Theater theater) {

        theaterService.save(theater);

    }

    // Method for PUT::"/theaters" endpoint.
    // update existing theater to the theaters table.
    @PutMapping("/theaters")
    public void updateTheater(@RequestBody Theater theater) {

        theaterService.save(theater);

    }

    // Method for DELETE::"/theaters/{id}" endpoint.
    // delete existing theater to the theaters table.
    @DeleteMapping("/theaters/{id}")
    public void deleteTheater(@PathVariable int id) {

        theaterService.delete(id);

    }
}
