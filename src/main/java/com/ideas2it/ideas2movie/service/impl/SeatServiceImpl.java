package com.ideas2it.ideas2movie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Seat;
import com.ideas2it.ideas2movie.service.SeatService;
import com.ideas2it.ideas2movie.repository.SeatRepository;

/**
 * <h1>
 *     Seat Service Impl
 * </h1>
 * <p>
 *     Implements the Seat Service and
 *     Holds the Business Logics
 *     to Create, Update, Delete, Get the Details of the Seat
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
@Service
public class SeatServiceImpl implements SeatService {
    private SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository){
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Seat> createSeat(Screen screen) {
        int name = 65;
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= screen.getTotalNumberOfRows(); row++){
            for (int column = 1; column <= screen.getTotalNumberOfColumns(); column++){
                Seat seat = new Seat();
                seat.setName(""+column+(char)name);
                seat.setScreen(screen);
                seats.add(seat);
            }
            name++;
        }
        return seatRepository.saveAll(seats);
    }

    @Override
    public List<Seat> getSeatsByScreenId(Long screenId)  {
        return seatRepository.findAllByScreenId(screenId);
    }
}
