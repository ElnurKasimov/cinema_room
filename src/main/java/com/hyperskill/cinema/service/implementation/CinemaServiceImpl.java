package com.hyperskill.cinema.service.implementation;

import com.hyperskill.cinema.dto.*;
import com.hyperskill.cinema.exception.EntityNotFoundException;
import com.hyperskill.cinema.model.Cinema;
import com.hyperskill.cinema.model.Seat;
import com.hyperskill.cinema.repository.CinemaRepository;
import com.hyperskill.cinema.service.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


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
        List<SeatResponse> seats = cinemaRepository.getCinema().getSeats().stream()
                .filter(seat -> seat.getToken() == null)
                .map(seatTransformer::fromEntity)
                .toList();
        return new CinemaResponse(cinemaRepository.getCinema().getRows(),
                                  cinemaRepository.getCinema().getColumns(),
                                  seats);
    }

    @Override
    public Cinema readCinema() {
        return cinemaRepository.getCinema();
    }
    @Override
    public Seat readSeat(int row, int column) {
        Optional<Seat> seat = cinemaRepository.getSeat(row, column);
        if(seat.isEmpty()) {
            throw new EntityNotFoundException("There is no such place.");
        }
        return seat.get();
    }

    @Override
    public boolean isSeatPurchased(int row, int column) {
        UUID token = readSeat(row, column).getToken();
        return token != null;
    }

    @Override
    public PurchaseResponse markSeatAsPurchased(int row, int column) {
        PurchaseResponse result = null;
        Cinema cinema = cinemaRepository.getCinema();
        List<Seat> seats = cinema.getSeats();
        for (Seat seat : seats) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                seat.setToken(UUID.randomUUID());
                result = new PurchaseResponse(seat);
                break;
            }
        }
        cinema.setSeats(seats);
        cinemaRepository.updateCinema(cinema);
        return result;
    }

    @Override
    public Optional<Seat> getSeatByToken(String token) {
        UUID tokenUUID = UUID.fromString(token);
        return cinemaRepository.getCinema().getSeats().stream()
                .filter(s -> tokenUUID.equals(s.getToken()))
                .findFirst();
    }

    @Override
    public void markSeatAsAvailable(Seat seat) {
        Cinema cinema = cinemaRepository.getCinema();
        List<Seat> seats = cinema.getSeats();
        for (Seat seatFromDB : seats) {
            if (seat.equals(seatFromDB)) {
                seatFromDB.setToken(null);
            }
        }
        cinema.setSeats(seats);
        cinemaRepository.updateCinema(cinema);
    }

    @Override
    public StatisticResponse getStats() {
        Cinema cinema = cinemaRepository.getCinema();
        int purchased = 0;
        int available = 0;
        int income = 0;
        List<Seat> seats = cinema.getSeats();
        for (Seat seat : seats) {
            if (seat.getToken() != null) {
                purchased++;
                income += seat.getPrice();
            } else {
                available++;
            }
        }
        return new StatisticResponse(income, available, purchased);
    }

}
