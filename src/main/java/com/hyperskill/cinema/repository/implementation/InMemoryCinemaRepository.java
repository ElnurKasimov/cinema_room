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
    public Cinema markPlaceAsPurchased(int row, int column) {
        List<Seat> seats = cinema.getSeats();
        for (Seat seat : seats) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                seat.setPurchased(true);
            }
        }
        cinema.setSeats(seats);
        return cinema;
    }

    @Override
    public Cinema markPlaceAsAvailable(int row, int column) {
        return null;
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


}
