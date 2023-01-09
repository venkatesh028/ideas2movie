package com.ideas2it.ideas2movie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Seat;
import com.ideas2it.ideas2movie.repository.SeatRepository;
import com.ideas2it.ideas2movie.service.SeatService;

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

    @Override
    public List<Seat> createSeat(Screen screen) {
        int name = 65;
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= screen.getTotalNumberOfRows(); row++){
            for (int coloumn = 1; coloumn <= screen.getTotalNumberOfColumns(); coloumn++){
                Seat seat = new Seat();
                seat.setName(""+coloumn+(char)name);
                seat.setScreen(screen);
                seats.add(seatRepository.save(seat));
            }
            name++;
        }
        return seats;
    }

    @Override
    public List<Seat> getSeatsByScreenId(Long id) {
        return seatRepository.findAllByScreenId(id);
    }
}
