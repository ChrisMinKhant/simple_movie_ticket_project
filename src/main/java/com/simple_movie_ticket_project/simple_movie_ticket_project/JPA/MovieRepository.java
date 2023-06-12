package com.simple_movie_ticket_project.simple_movie_ticket_project.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Movie;

/*
 * Movie Repository for CRUD operations.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
