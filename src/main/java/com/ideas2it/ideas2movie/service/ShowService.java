/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import java.util.List;

import com.ideas2it.ideas2movie.dto.ShowDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ShowResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotAcceptableException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Show;

/**
 * <h1>
 *     Show Service
 * </h1>
 * <p>
 *     ShowService used to manage the Operation for the Show
 *     Like Create, Cancel and Get the Details of the Show
 *     and throws an Exception when occurred
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
public interface ShowService {

    /**
     * <h1>
     *     createShow
     * </h1>
     * <p>
     *     Gets the Details of the Show to Create a new Show For a Screen
     *     and checks whether the Details of the Show is already Exist or not
     *     then save the Show to storage or throws an Exception
     * </p>
     *
     * @param showDTO - Holds the details of the show
     * @return showResponseDTO - Holds the response details of the show
     * @throws AlreadyExistException - Occurs When the given show is already exist
     */
    ShowResponseDTO createShow(ShowDTO showDTO) throws AlreadyExistException, NotAcceptableException, BadRequestException;

    /**
     * <h1>
     *     cancelShow
     * </h1>
     * <p>
     *     Gets the ID of the Show to cancel the Show for a Screen
     *     and checks whether the show is already Exist or not
     *     then change the status of the show or throws an Exception
     * </p>
     *
     * @param id - Holds the id of the show
     * @return message - Holds the canceled successfully message
     * @throws NotFoundException - Occurs When there is no show with given id
     */
    String cancelShow(Long id) throws NotFoundException;

    /**
     * <h1>
     *     getAllShowsByMovieName
     * </h1>
     * <p>
     *     Gets the Movie name to Fetch all the Shows for the Movie
     *     and checks whether any show is allocated for a movie or Not
     *     then returns the Details of the Shows or throws an Exception
     * </p>
     *
     * @param movieName - Holds the name of the movie
     * @return listOfShows - Holds the list of shows
     * @throws NoContentException - Occurs when there is empty list obtained for the given movie name
     */
    List<ShowResponseDTO> getAllShowsByMovieName(String movieName) throws NoContentException;

    /**
     * <h1>
     *     getShowById
     * </h1>
     * <p>
     *     Gets the ID of the Show to get the Details of that Show
     *     and Checks whether the show is Exist or not
     *     then returns the Details of the Show or throws an Exception
     * </p>
     *
     * @param id - Holds the id of the Show
     * @return showResponseDTo - Holds the details of the show in response dto
     * @throws NotFoundException - Occurs when there is no show for the given id
     */
    ShowResponseDTO getShowById(Long id) throws NotFoundException;

    List<Show> getAllShowsForScreen(Long id) throws NoContentException;
}
