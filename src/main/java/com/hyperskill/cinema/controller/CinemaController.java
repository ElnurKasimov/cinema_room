package com.hyperskill.cinema.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.hyperskill.cinema.dto.CinemaResponse;
import com.hyperskill.cinema.dto.SeatResponse;
import com.hyperskill.cinema.exception.InvalidBoundaryException;
import com.hyperskill.cinema.exception.PurchasedException;
import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.model.PurchaseRequest;
import com.hyperskill.cinema.service.CinemaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
//    @PostMapping("/purchase")
//    SeatResponse getSeatInfo(@RequestBody PurchaseRequest purchaseRequest) throws JsonProcessingException {
//        int maxRow = cinemaService.getCinemaInfo().getRows();
//        int maxColumn = cinemaService.getCinemaInfo().getColumns();
//        int row = purchaseRequest.getRow();
//        int column = purchaseRequest.getColumn();
//        if ( (row < 1 || row > maxRow) || (column < 1 || column > maxColumn) ) {
//            throw new InvalidBoundaryException("The number of a row or a column is out of bounds!");
//        } else if (cinemaService.isSeatPurchased(row, column)) {
//            throw new PurchasedException("The ticket has been already purchased!");
//            } else {
//            return cinemaService.markPlaceAsPurchased(row, column);
//        }
//    }
}
