package com.hyperskill.cinema.service.implementation;



import com.hyperskill.cinema.model.Seat;
import com.hyperskill.cinema.service.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Override
    public int getRowQuantity() {
        return 0;
    }

    @Override
    public int getColumnQuantity() {
        return 0;
    }

    @Override
    public List<Seat> getAllSeats() {
        return null;
    }

    @Override
    public Seat getSeatInfo(int row, int column) {
        return new Seat(row,column);
    }
}
