package com.hyperskill.cinema.model;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private int rows;
    private int columns;
    List<Seat> seats = new ArrayList<>();

    public Cinema (int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                Seat seat = new Seat(i,j);
                seats.add(seat);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
