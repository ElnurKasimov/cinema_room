package com.hyperskill.cinema.service;



import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.model.Seat;

import java.util.List;

public interface CinemaService {

    Cinema getCinemaInfo();
    Seat getSeatInfo(int row, int column);
}
