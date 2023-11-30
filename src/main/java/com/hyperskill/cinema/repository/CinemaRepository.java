package com.hyperskill.cinema.repository;

import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.model.Seat;

import java.util.Optional;

public interface CinemaRepository {
    public Cinema getCinema();
    public Optional<Seat> getSeat(int row, int column);
    public void updateCinema(Cinema cinema);

}
