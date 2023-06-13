package com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.ResponseDTO;

import org.springframework.stereotype.Component;

import lombok.Data;

/*
 * DTO layer for User Entity.
 * This layer only expose name, age, phone, email, and address
 * and hide user's password, enabled status, and roles.
 */
@Data
@Component
public class UserResponseDTO {

    private String name;
    private String age;
    private String phone;
    private String email;
    private String address;
}
