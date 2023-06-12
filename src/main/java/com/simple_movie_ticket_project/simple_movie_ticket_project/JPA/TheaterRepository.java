package com.simple_movie_ticket_project.simple_movie_ticket_project.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Theater;

/*
 * Theater Repository for CRUD Operations.
 */
@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {

}
