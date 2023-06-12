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
 * Entity class for movies table.
 */
@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "pg")
    private String pg;

    @Column(name = "rating")
    private String rating;

    // No arg constructor
    public Movie() {

    }

    // Four args constructor
    public Movie(String title, String description, String pg, String rating) {
        this.title = title;
        this.description = description;
        this.pg = pg;
        this.rating = rating;
    }
}
