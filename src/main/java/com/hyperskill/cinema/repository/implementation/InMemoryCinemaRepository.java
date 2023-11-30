package com.hyperskill.cinema.repository.implementation;

import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.model.Seat;
import com.hyperskill.cinema.repository.CinemaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCinemaRepository  implements CinemaRepository {
    private Cinema cinema = new Cinema(9, 9);

    @Override
    public Cinema getCinema() {
        return cinema;
    }

    @Override
    public Optional<Seat> getSeat(int row, int column) {
        return cinema.getSeats().stream()
                .filter(seat -> seat.getRow() == row && seat.getColumn() == column)
                .findFirst();
    }

    @Override
    public void updateCinema(Cinema cinema) {
        this.cinema = cinema;
    }


}
