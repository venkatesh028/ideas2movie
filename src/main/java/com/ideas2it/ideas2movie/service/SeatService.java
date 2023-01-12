package com.ideas2it.ideas2movie.service;

import java.util.List;

import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Seat;

/**
 * <h1>
 *     SeatService
 * </h1>
 * <p>
 *     SeatService used to manage the Operation for the Seat
 *     Like Creating and Fetching the Details of the Seat and throws an Exception when occurred
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
     *     Gets Screen Details which Holds the Row and Column count to create Seats for the Screen
     *     and stores it to the Storage and returns the list of Seat
     * </p>
     *
     * @param screen - Holds the Details of the Screen
     * @return listOfSeats - Holds the list of seats Created
     */
    List<Seat> createSeat(Screen screen);

    /**
     * <h1>
     *     getSeatsByScreenId
     * </h1>
     * <p>
     *     Gets the ID of the Screen to get all the Seats which are allocated to the
     *     particular Screen and returns the Details of the Seats
     * </p>
     * @param screenId - Holds the id of the screen
     * @return listOfSeats - Holds the list of seats for that screen
     */
    List<Seat> getSeatsByScreenId(Long screenId);
}
