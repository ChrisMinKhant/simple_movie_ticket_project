package com.simple_movie_ticket_project.simple_movie_ticket_project.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*
 * Entity class for tickets table.
 */
@Setter
@Getter
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
     * cascade = {} is used to disable Cascading effect.
     */

    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    @JoinColumn(name = "show_times_id")
    private ShowTime showTime;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    @JoinColumn(name = "prices_id")
    private Price price;

    // No argument constructor;
    public Ticket() {
    }

    // Four Arguments contructor.
    public Ticket(Movie movie, Theater theater, ShowTime showTime, Price price) {
        this.movie = movie;
        this.theater = theater;
        this.showTime = showTime;
        this.price = price;
    }
}
