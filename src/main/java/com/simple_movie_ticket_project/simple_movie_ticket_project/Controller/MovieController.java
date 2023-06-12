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

import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Implementations.MovieService;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Movie;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Theater;

@RestController
@RequestMapping("/api")
public class MovieController {

    // For Dependency Injection
    private MovieService movieService;

    // Constructor Injection
    MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Method for GET::"/movies" endpoint.
    // get all the movies from the movies table.
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {

        // Create Empty Movie List Object.
        List<Movie> movie = new ArrayList<Movie>();

        movie = movieService.findAll();

        return movie;
    }

    // Method for GET::"/movies/{id}" endpoint.
    // get one specific movie from the movies table.
    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable int id) {

        // Create empty Movie object.
        Movie movie = new Movie();

        movie = movieService.findById(id);

        return movie;
    }

    // Method for POST::"/movies" endpoint.
    // save new movie to the movies table.
    @PostMapping("/movies")
    public void saveNewMovie(@RequestBody Movie movie) {

        movieService.save(movie);

    }

    // Method for PUT::"/movies" endpoint.
    // update existing movie to the movies table.
    @PutMapping("/movies")
    public void updateMovie(@RequestBody Movie movie) {

        movieService.save(movie);

    }

    // Method for DELETE::"/movies/{id}" endpoint.
    // delete existing movie to the movies table.
    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable int id) {

        movieService.delete(id);

    }
}
