package com.hyperskill.cinema.dto;

import com.hyperskill.cinema.model.Seat;

public class PurchaseResponse {
    private String token;
    SeatResponse ticket;

    public PurchaseResponse(Seat seat) {
        this.token = seat.getToken().toString();
        this.ticket = new SeatResponse(seat);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SeatResponse getTicket() {
        return ticket;
    }

    public void setTicket(SeatResponse ticket) {
        this.ticket = ticket;
    }
}
