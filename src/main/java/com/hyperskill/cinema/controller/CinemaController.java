package com.hyperskill.cinema.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyperskill.cinema.exception.InvalidBoundaryException;
import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.service.CinemaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {
    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    String getCinema() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(cinemaService.getCinemaInfo());
    }
    @GetMapping("/seats/{row}/{column}")
    String getSeatInfo(@PathVariable int row, @PathVariable int column) throws JsonProcessingException {
        int maxRow = cinemaService.getCinemaInfo().getRows();
        int maxColumn = cinemaService.getCinemaInfo().getColumns();
        if (row < 1 || row > maxRow) {
            throw new InvalidBoundaryException("Row number should be from 1 to " + maxRow);
        } else if (column < 1 || column > maxColumn) {
            throw new InvalidBoundaryException("Column number should be from 1 to " + maxColumn);
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(cinemaService.getSeatInfo(row, column));
        }
    }
}
