package com.hyperskill.cinema.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.hyperskill.cinema.dto.*;
import com.hyperskill.cinema.exception.AuthorizationException;
import com.hyperskill.cinema.exception.EntityNotFoundException;
import com.hyperskill.cinema.exception.InvalidBoundaryException;
import com.hyperskill.cinema.exception.PurchasedException;
import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.model.Seat;
import com.hyperskill.cinema.service.CinemaService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CinemaController {
    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    CinemaResponse getCinemaInfo() throws JsonProcessingException {
        return cinemaService.getCinemaInfo();
    }

    @GetMapping("/all-seats")
    Cinema getCinema() throws JsonProcessingException {
        return cinemaService.readCinema();
    }
    @PostMapping("/purchase")
    PurchaseResponse postPurchase(@RequestBody PurchaseRequest purchaseRequest) throws JsonProcessingException {
        int maxRow = cinemaService.getCinemaInfo().getRows();
        int maxColumn = cinemaService.getCinemaInfo().getColumns();
        int row = purchaseRequest.getRow();
        int column = purchaseRequest.getColumn();
        if ( (row < 1 || row > maxRow) || (column < 1 || column > maxColumn) ) {
            throw new InvalidBoundaryException("The number of a row or a column is out of bounds!");
        } else if (cinemaService.isSeatPurchased(row, column)) {
            throw new PurchasedException("The ticket has been already purchased!");
            } else {
            return cinemaService.markSeatAsPurchased(row, column);
        }
    }

    @PostMapping("/return")
    ReturnResponse postReturn(@RequestBody ReturnRequest returnRequest) throws JsonProcessingException {
        String token = returnRequest.getToken();
        Optional<Seat> seat = cinemaService.getSeatByToken(token);
        if (seat.isEmpty()) {
            throw new EntityNotFoundException("Wrong token!");
        } else {
            ReturnResponse result = new ReturnResponse(seat.get());
            cinemaService.markSeatAsAvailable(seat.get());
            return result;
        }
    }

    @GetMapping("/stats")
    StatisticResponse getStatistic(@RequestParam(required = false) String password) {
        if ("super_secret".equals(password)) {
            return cinemaService.getStats();
        } else {
            throw new AuthorizationException("The password is wrong!");
        }
    }
}
