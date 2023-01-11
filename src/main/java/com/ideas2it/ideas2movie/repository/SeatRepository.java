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
 *     Repository of  the seat
 *     to save and fetch the details of
 *     seat using the JPARepository
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 10/01/2023
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    Seat findByName(String name);

    /**
     * <h1>
     *     findAllByScreenId
     * </h1>
     * <p>
     *     Fetch all the seats of the
     *     particular screen based on the
     *     id
     * </p>
     * @param id - Holds the id of screen
     * @return listOfSeats - Holds the list of seats
     */
    List<Seat> findAllByScreenId(Long id);
}
