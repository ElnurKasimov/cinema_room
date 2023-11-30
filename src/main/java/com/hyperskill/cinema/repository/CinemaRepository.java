package com.hyperskill.cinema.repository;

import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.model.Seat;

public interface CinemaRepository {
    public Cinema getCinema();
    public Cinema markPlaceAsPurchased(int row, int column);
    public Cinema markPlaceAsAvailable(int row, int column);

    public Seat getSeat(int row, int column);

}
