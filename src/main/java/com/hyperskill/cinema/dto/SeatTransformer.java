package com.hyperskill.cinema.dto;

import com.hyperskill.cinema.model.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatTransformer {

    public SeatResponseForCinema fromEntity(Seat seat) {
        return new SeatResponseForCinema(seat);
    }
}
