package com.simple_movie_ticket_project.simple_movie_ticket_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 *  Entity class for users table.
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    // No Args Constructor
    public User() {

    }

    // Five Args Constructor
    public User(String name, String age, String phone, String email, String address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
