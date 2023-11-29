package com.hyperskill.cinema.repository;

import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.model.Seat;

public interface CinemaRepository {
    public Cinema getCinema();

    public Seat getSeat(int row, int column);
}
