package com.hyperskill.cinema.dto;

import java.util.List;

public class CinemaResponse {
    private int rows;
    private int columns;
    private List<SeatResponse> seats;

    public CinemaResponse(int rows, int columns, List<SeatResponse> seats) {
        this.rows = rows;
        this.columns = columns;
        this.seats = seats;
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

    public List<SeatResponse> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatResponse> seats) {
        this.seats = seats;
    }
}
