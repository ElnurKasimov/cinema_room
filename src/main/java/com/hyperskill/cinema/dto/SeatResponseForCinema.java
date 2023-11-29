package com.hyperskill.cinema.dto;

import com.hyperskill.cinema.model.Seat;

public class SeatResponseForCinema {
    public int row;
    public int column;

    public SeatResponseForCinema (Seat seat) {
        this.row = seat.getRow();
        this.column = seat.getColumn();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
