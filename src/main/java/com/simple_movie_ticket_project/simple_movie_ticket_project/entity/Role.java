package com.simple_movie_ticket_project.simple_movie_ticket_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 * Entity class for roles table.
 */
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {})
    @JoinColumn(name = "email")
    @JsonBackReference
    private User user;

    @Column(name = "role")
    private String role;

    // No arg constructor
    public Role() {
    }

    // Two args constructor
    public Role(User user, String role) {
        this.user = user;
        this.role = role;
    }
}
