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
 * Entity class for prices table.
 */
@Getter
@Setter
@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "prices")
    private String price;

    // No arg constructor
    public Price() {

    }

    // One arg constructor
    public Price(String price) {
        this.price = price;
    }
}
