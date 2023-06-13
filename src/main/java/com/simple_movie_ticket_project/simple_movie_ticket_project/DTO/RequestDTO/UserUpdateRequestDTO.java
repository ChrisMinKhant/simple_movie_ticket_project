package com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO;

import org.springframework.stereotype.Component;

import lombok.Data;

/*
 * DTO layer for user update request.
 * This layer only accept user's name, age, phone, email, address.
 */
@Data
@Component
public class UserUpdateRequestDTO {

    private String name;
    private String age;
    private String phone;
    private String email;
    private String address;
}
