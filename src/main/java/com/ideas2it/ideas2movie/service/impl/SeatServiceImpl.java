package com.ideas2it.ideas2movie.service.impl;

import org.springframework.stereotype.Service;

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
    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }
}
