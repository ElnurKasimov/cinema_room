package com.hyperskill.cinema.dto;

import com.hyperskill.cinema.model.Cinema;

import java.util.List;
import java.util.stream.Collectors;

public class CinemaResponse {
    private int rows;
    private int columns;
    private List<SeatResponseForCinema> seats;

    public CinemaResponse(int rows, int columns, List<SeatResponseForCinema> seats) {
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

    public List<SeatResponseForCinema> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatResponseForCinema> seats) {
        this.seats = seats;
    }
}
