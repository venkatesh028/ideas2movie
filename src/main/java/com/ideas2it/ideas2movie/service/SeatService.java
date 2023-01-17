package com.ideas2it.ideas2movie.service;

import java.util.List;

import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Seat;

/**
 * <h1>
 *     SeatService
 * </h1>
 * <p>
 *     SeatService used to manage the Operation for the Seat
 *     Like Creating seat for a screen and Fetching the Details of the Seat for Screen
 *     and throws an Exception when occurred
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
     *     Creates Seat For Scree based on Row and Column count of the screen
     *     and returns the list of Seat
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
     *     Retrieves all the Seats which are allocated to the
     *     particular Screen based on the id of the screen
     * </p>
     * @param screenId - Holds the id of the screen
     * @return listOfSeats - Holds the list of seats for that screen
     */
    List<Seat> getSeatsByScreenId(Long screenId);

    /**
     * <h1>
     *     getSeatById
     * </h1>
     * <p>
     *     Retrieves Seat based on the id of the seat checks the
     *     seat is exists if exists return the seat else
     *     throws exception
     * </p>
     * @param id - Holds the id of the seat
     * @return Seat - Holds the details of seat
     * @throws NotFoundException - Occurs when there is no seat with given id
     */
    Seat getSeatById(Long id) throws NotFoundException;
}
