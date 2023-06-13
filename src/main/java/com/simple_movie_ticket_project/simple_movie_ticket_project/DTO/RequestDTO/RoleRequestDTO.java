package com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO;

import org.springframework.stereotype.Component;

import lombok.Data;

/*
 * Request DTO layer for role.
 */
@Data
@Component
public class RoleRequestDTO {
    private String userEmail;
    private String role;
}
