package com.simple_movie_ticket_project.simple_movie_ticket_project.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.PriceServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Price;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Theater;

@RestController
@RequestMapping("/api")
public class PriceController {
    // For Dependency Injection
    private PriceServiceInterface priceService;

    // Constructor Injection
    PriceController(PriceServiceInterface priceService) {
        this.priceService = priceService;
    }

    // Method for GET::"/prices" endpoint.
    // get all the prices from the prices table.
    @GetMapping("/prices")
    public List<Price> getAllPrices() {

        // Create Empty Price List Object.
        List<Price> price = new ArrayList<Price>();

        price = priceService.findAll();

        return price;
    }

    // Method for GET::"/prices/{id}" endpoint.
    // get one specific price from the prices table.
    @GetMapping("/prices/{id}")
    public Price getPriceById(@PathVariable int id) {

        // Create empty Price object.
        Price price = new Price();

        price = priceService.findById(id);

        return price;
    }

    // Method for POST::"/prices" endpoint.
    // save new price to the prices table.
    @PostMapping("/prices")
    public void saveNewPrice(@RequestBody Price price) {

        priceService.save(price);

    }

    // Method for PUT::"/prices" endpoint.
    // update existing price to the prices table.
    @PutMapping("/prices")
    public void updatePrice(@RequestBody Price price) {

        priceService.save(price);

    }

    // Method for DELETE::"/prices/{id}" endpoint.
    // delete existing price to the prices table.
    @DeleteMapping("/prices/{id}")
    public void deletePrice(@PathVariable int id) {

        priceService.delete(id);

    }
}
