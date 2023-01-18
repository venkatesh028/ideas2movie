/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.ideas2movie.model.Show;

/**
 * <h1>
 *     ShowRepository
 * </h1>
 * <p>
 *     ShowRepository provides the CRUD of the Show by extending JPARepository like Saving the Show
 *     And Fetching the details of the show and contains the custom methods
 *     to fetch the show based on screen id , Movie name and screening date
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 10/01/2023
 */
@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    /**
     * <h1>
     *     findByMovieName
     * </h1>
     * <p>
     *     Fetch the listShow based on the
     *     movie name
     * </p>
     *
     * @param movieName - Name of the movie
     * @return lisOfShows - Holds the list of shows for the particular movie
     */
    List<Show> findByMovieName(String movieName);

    /**
     * <h1>
     *     findAllByScreenDateAndScreenId
     * </h1>
     * <p>
     *     Fetch All the Shows based on te Screening date and ScreenId
     * </p>
     * @param screeningDate - Date When the show is screening
     * @param id - ID of the screen
     * @return shows - Holds the list of shows screening on that date in that screen
     */
    List<Show> findAllByScreeningDateAndScreenId(LocalDate screeningDate, Long id);

    /**
     * <h1>
     *     findAllByScreenId
     * </h1>
     * <p>
     *     Fetch All the Shows for the particular screen based on the id of the screen
     * </p>
     * @param id - ID of the screen
     * @return shows - Holds the list of shows screening on that screen
     */
    List<Show> findAllByScreenId(Long id);
}
