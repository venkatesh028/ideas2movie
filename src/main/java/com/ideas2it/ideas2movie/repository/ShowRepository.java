/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Show;

/**
 * <h1>
 *     ShowRepository
 * </h1>
 * <p>
 *     Repository of  the show
 *     to save and fetch the details of
 *     show using the JPARepository
 * </p>
 *
 * @author Venkatesh TM
 * @vesion 1.0
 * @since 10/01/2023
 */
@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    /**
     * <h1>
     *     existsByScreeningDateAndStartTimeAndScreen
     * </h1>
     * <p>
     *     Checks show is exist for
     *     given screeningDate, StartTime
     *     and screen
     * </p>
     *
     * @param screeningDate - Holds the date when the show is screening
     * @param startTime - Holds the start time of the show
     * @param screen - Holds the Screen details
     * @return isExists - Holds the response of the isExists
     */
    boolean existsByScreeningDateAndStartTimeAndScreen(LocalDate screeningDate,
                                                       LocalTime startTime,
                                                       Screen screen);

    /**
     * <h1>
     *     findByMovieName
     * </h1>
     * <p>
     *     Fetch the listShow based on the
     *     movie name
     * </p>
     *
     * @param movieName - Holds the name of the movie
     * @return lisOfShows - Holds the list of shows for the particular movie
     */
    List<Show> findByMovieName(String movieName);

    List<Show> findByScreenId(Long id);
}
