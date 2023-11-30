package com.hyperskill.cinema.service.implementation;



import com.hyperskill.cinema.dto.CinemaResponse;
import com.hyperskill.cinema.dto.CinemaTransformer;
import com.hyperskill.cinema.dto.SeatResponseForCinema;
import com.hyperskill.cinema.dto.SeatTransformer;
import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.model.Seat;
import com.hyperskill.cinema.repository.CinemaRepository;
import com.hyperskill.cinema.service.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;
    private final SeatTransformer seatTransformer;
    private final CinemaTransformer cinemaTransformer;

    public CinemaServiceImpl(CinemaRepository cinemaRepository, SeatTransformer seatTransformer, CinemaTransformer cinemaTransformer) {
        this.cinemaRepository = cinemaRepository;
        this.seatTransformer = seatTransformer;
        this.cinemaTransformer = cinemaTransformer;
    }

    @Override
    public CinemaResponse getCinemaInfo() {
        Cinema cinemaEntity = cinemaRepository.getCinema();
        cinemaEntity.setSeats(cinemaEntity.getSeats().stream()
                .filter(seat -> !seat.isPurchased())
                .toList());
        return cinemaTransformer.fromEntity(cinemaEntity);
    }
    @Override
    public Seat getSeatInfo(int row, int column) {
        return new Seat(row,column);
    }
}
