package com.hyperskill.cinema.dto;

import com.hyperskill.cinema.model.Seat;

public class SeatResponseForCinema {
    public int row;
    public int column;

    public int price;

    public SeatResponseForCinema (Seat seat) {
        this.row = seat.getRow();
        this.column = seat.getColumn();
        this.price = seat.getPrice();
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
