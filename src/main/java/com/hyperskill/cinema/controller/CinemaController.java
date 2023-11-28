package com.hyperskill.cinema.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.service.CinemaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {
    private final CinemaService cinemaService;
    private final Cinema cinema = new Cinema(9, 9);

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    String getAllSeats() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(cinema);
    }
    @GetMapping("/seats/{row}/{column}")
    String getSeatInfo(@PathVariable int row, @PathVariable int column) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(cinemaService.getSeatInfo(row, column));
    }
}
