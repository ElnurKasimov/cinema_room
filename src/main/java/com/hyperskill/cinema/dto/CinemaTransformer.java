package com.hyperskill.cinema.dto;

import com.hyperskill.cinema.model.Cinema;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CinemaTransformer {
    private final SeatTransformer seatTransformer;

    public CinemaTransformer(SeatTransformer seatTransformer) {
        this.seatTransformer = seatTransformer;
    }

    public CinemaResponse fromEntity(Cinema cinema) {
        List<SeatResponseForCinema> seats = cinema.getSeats().stream()
                .map(this.seatTransformer::fromEntity)
                .toList();
        return new CinemaResponse(cinema.getRows(), cinema.getColumns(), seats);
    }
}
