/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import java.util.List;

import com.ideas2it.ideas2movie.dto.ShowDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ShowResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Show;

/**
 * <h1>
 *     Show Service
 * </h1>
 * <p>
 *     Service Layer for the Show
 *     to Create, Update, Get
 *     and Delete the details of the Show
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
public interface ShowService {

    /**
     * <h1>
     *     Create Show
     * </h1>
     * <p>
     *     Creates the Show for Movie
     *     By getting the showDTO from the Controller
     *     And Checks the Show is already exist for the movie
     *     or for other movie in the same screen with help of
     *     streaming date, start time and screen id if the show
     *     is already exist Exception is thrown
     * </p>
     * @param showDTO - Holds the details of the show
     * @return showResponseDTO - Holds the response details of the show
     * @throws AlreadyExistException - Occurs When the given show is already exist
     */
    ShowResponseDTO createShow(ShowDTO showDTO) throws AlreadyExistException, NotFoundException;

    String deactivateTheShow(Long id) throws NotFoundException;

    List<Show> getAllShowsByMovieId(String movieName) throws NoContentException;

    Show updateAvailableSeatsOfShow(int bookedSeats, Long showId);

}
