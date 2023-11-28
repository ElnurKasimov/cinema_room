package com.hyperskill.cinema.service;



import com.hyperskill.cinema.model.Seat;

import java.util.List;

public interface CinemaService {
    int getRowQuantity();
    int getColumnQuantity();
    List<Seat> getAllSeats();
    Seat getSeatInfo(int row, int column);
}
