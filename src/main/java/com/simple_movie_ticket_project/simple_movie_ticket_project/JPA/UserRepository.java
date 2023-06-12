package com.simple_movie_ticket_project.simple_movie_ticket_project.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.User;

/*
 * User Repository Interface for CRUD operation.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
