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
 * Entity class for show_times table.
 */
@Getter
@Setter
@Entity
@Table(name = "show_times")
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "times")
    private String time;

    // No arg constructor
    public ShowTime() {

    }

    // One arg constructor
    public ShowTime(String time) {
        this.time = time;
    }
}
