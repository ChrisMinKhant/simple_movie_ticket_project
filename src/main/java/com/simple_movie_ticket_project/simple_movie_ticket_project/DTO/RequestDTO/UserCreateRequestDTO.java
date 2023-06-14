package com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO;

import org.springframework.stereotype.Component;

import lombok.Data;

/*
 * DTO layer to making user request.
 */
@Data
@Component
public class UserCreateRequestDTO {

    private String name;
    private String age;
    private String phone;
    private String email;
    private String password;
    private String address;
}
