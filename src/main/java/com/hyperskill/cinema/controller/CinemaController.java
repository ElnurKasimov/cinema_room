package com.hyperskill.cinema.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyperskill.cinema.model.Cinema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {
    private final Cinema cinema = new Cinema(9, 9);

    @GetMapping("/seats")
    String getAllSeats() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(cinema);
        return result;
    }
}
