package com.hyperskill.cinema.dto;

import com.hyperskill.cinema.model.Seat;

public class RefundResponse {
    private String token;
    SeatResponse ticket;

    public RefundResponse(Seat seat) {
        this.token = seat.getToken().toString();
        this.ticket = new SeatResponse(seat);
    }
}
