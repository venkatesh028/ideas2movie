package com.ideas2it.ideas2movie.service;

import java.util.List;

import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Seat;

/**
 * <h1>
 *     Seat Service
 * </h1>
 * <p>
 *     Service Layer for the Seat
 *     to Create, Update, Get
 *     and Delete the details of the Seat
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
public interface SeatService {
    List<Seat> createSeat(Screen createdScreen);

    List<Seat> getSeatsByScreenId(Long id);
}
