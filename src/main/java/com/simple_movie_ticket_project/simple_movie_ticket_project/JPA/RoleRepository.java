package com.simple_movie_ticket_project.simple_movie_ticket_project.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Role;

/*
 * Role Repository for basic role CRUD
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
