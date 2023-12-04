package com.hyperskill.cinema.dto;

import com.hyperskill.cinema.model.Seat;

public class ReturnResponse {
      SeatResponse ticket;

    public ReturnResponse(Seat seat) {
        this.ticket = new SeatResponse(seat);
    }

    public SeatResponse getTicket() {
        return ticket;
    }

    public void setTicket(SeatResponse ticket) {
        this.ticket = ticket;
    }
}
