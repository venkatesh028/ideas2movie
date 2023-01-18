/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.ideas2movie.model.Seat;

/**
 * <h1>
 *     SeatRepository
 * </h1>
 * <p>
 *     SeatRepository provides the CRUD of the Seat by extending JPARepository like Saving the Seat
 *     And Fetching the details of the seat and contains the custom methods
 *     to fetch the seat based on the screen ID
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 10/01/2023
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    /**
     * <h1>
     *     findAllByScreenId
     * </h1>
     * <p>
     *     Fetch all the seats of the
     *     particular screen based on the
     *     ID
     * </p>
     * @param id - Holds the id of screen
     * @return listOfSeats - Holds the list of seats
     */
    List<Seat> findAllByScreenId(Long id);
}
