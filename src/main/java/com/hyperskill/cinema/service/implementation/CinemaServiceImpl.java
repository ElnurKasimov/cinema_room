package com.hyperskill.cinema.service.implementation;



import com.hyperskill.cinema.dto.CinemaResponse;
import com.hyperskill.cinema.dto.CinemaTransformer;
import com.hyperskill.cinema.dto.SeatResponse;
import com.hyperskill.cinema.dto.SeatTransformer;
import com.hyperskill.cinema.exception.EntityNotFoundException;
import com.hyperskill.cinema.exception.InvalidBoundaryException;
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
        return token == null;
    }

 //   @Override
//    public SeatResponse markPlaceAsPurchased(int row, int column) {
//        SeatResponse result = null;
//        Cinema cinema = cinemaRepository.getCinema();
//        List<Seat> seats = cinema.getSeats();
//        for (Seat seat : seats) {
//            if (seat.getRow() == row && seat.getColumn() == column) {
//                seat.setPurchased(true);
//                result = new SeatResponse(seat);
//            }
//        }
//        cinema.setSeats(seats);
//        cinemaRepository.updateCinema(cinema);
//        return result;
//    }

//    @Override
//    public void markPlaceAsAvailable(int row, int column) {
//        Cinema cinema = cinemaRepository.getCinema();
//        List<Seat> seats = cinema.getSeats();
//        for (Seat seat : seats) {
//            if (seat.getRow() == row && seat.getColumn() == column) {
//                seat.setPurchased(false);
//            }
//        }
//        cinema.setSeats(seats);
//        cinemaRepository.updateCinema(cinema);
//    }

}
