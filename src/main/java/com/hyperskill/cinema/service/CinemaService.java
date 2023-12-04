package com.hyperskill.cinema.service;



import com.hyperskill.cinema.dto.CinemaResponse;
import com.hyperskill.cinema.dto.PurchaseResponse;
import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.model.Seat;

import java.util.Optional;

public interface CinemaService {
    CinemaResponse getCinemaInfo();
    Cinema readCinema();
    Seat readSeat(int row, int column);
    boolean isSeatPurchased(int row, int column);

    public PurchaseResponse markSeatAsPurchased(int row, int column);

    public Optional<Seat> getSeatByToken(String token);

    public void markSeatAsAvailable(Seat  seat);

}
