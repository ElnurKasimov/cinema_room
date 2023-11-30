package com.hyperskill.cinema.service;



import com.hyperskill.cinema.dto.CinemaResponse;
import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.model.Seat;

import java.util.List;

public interface CinemaService {
    CinemaResponse getCinemaInfo();
    Seat getSeat(int row, int column);
    boolean isSeatPurchased(int row, int column);



}
