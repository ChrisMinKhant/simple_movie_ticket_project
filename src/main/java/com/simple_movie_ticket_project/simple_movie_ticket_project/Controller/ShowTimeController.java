package com.simple_movie_ticket_project.simple_movie_ticket_project.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.ShowTimeServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.ShowTime;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Theater;

@RestController
@RequestMapping("/api")
public class ShowTimeController {
    // For Dependency Injection
    private ShowTimeServiceInterface showTimeService;

    // Constructor Injection
    ShowTimeController(ShowTimeServiceInterface showTimeService) {
        this.showTimeService = showTimeService;
    }

    // Method for GET::"/show-times" endpoint.
    // get all the show-time from the show-times table.
    @GetMapping("/show-times")
    public List<ShowTime> getAllShowTimes() {

        // Create Empty ShowTime List Object.
        List<ShowTime> showTime = new ArrayList<ShowTime>();

        showTime = showTimeService.findAll();

        return showTime;
    }

    // Method for GET::"/show-times/{id}" endpoint.
    // get one specific show-time from the show-times table.
    @GetMapping("/show-times/{id}")
    public ShowTime getShowTimeById(@PathVariable int id) {

        // Create empty ShowTime object.
        ShowTime showTime = new ShowTime();

        showTime = showTimeService.findById(id);

        return showTime;
    }

    // Method for POST::"/show-times" endpoint.
    // save new show-time to the show-times table.
    @PostMapping("/show-times")
    public void saveNewShowTime(@RequestBody ShowTime showTime) {

        showTimeService.save(showTime);

    }

    // Method for PUT::"/show-times" endpoint.
    // update existing show-time to the show-times table.
    @PutMapping("/show-times")
    public void updateShowTime(@RequestBody ShowTime showTime) {

        showTimeService.save(showTime);

    }

    // Method for DELETE::"/show-times/{id}" endpoint.
    // delete existing show-time to the show-times table.
    @DeleteMapping("/show-times/{id}")
    public void deleteShowTime(@PathVariable int id) {

        showTimeService.delete(id);

    }
}
