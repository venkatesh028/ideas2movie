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
 *     to Create, Get the details
 *     of the Seat
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
public interface SeatService {


    /**
     * <h1>
     *     createSeat
     * </h1>
     * <p>
     *     Gets the Screen Details
     *     And creates the number of
     *     seats based on the based
     *     on total number of rows
     *     and column in screen
     * </p>
     * @param screen - Holds the Details of the Screen
     * @return listOfSeats - Holds the list of seats Created
     */
    List<Seat> createSeat(Screen screen);

    /**
     * <h1>
     *     getSeatsByScreenId
     * </h1>
     * <p>
     *     Gets the List of Seats For Particular
     *     Screen with the screen id
     * </p>
     * @param id - Holds the id of the screen
     * @return listOfSeats - Holds the list of seats for that screen
     */
    List<Seat> getSeatsByScreenId(Long id);
}
