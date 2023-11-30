package com.hyperskill.cinema.repository.implementation;

import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.model.Seat;
import com.hyperskill.cinema.repository.CinemaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryCinemaRepository  implements CinemaRepository {
    private Cinema cinema = new Cinema(9, 9);

    @Override
    public Cinema getCinema() {
        return cinema;
    }

    @Override
    public Seat getSeat(int row, int column) {
        for (Seat seat : cinema.getSeats()) {
            if(seat.getRow() == row && seat.getColumn() == column) {
                return seat;
            }
        }
        return null;
    }

    @Override
    public void updateCinema(Cinema cinema) {
        this.cinema = cinema;
    }


}
