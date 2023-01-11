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
import com.ideas2it.ideas2movie.exception.NotAcceptableException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Screen;

/**
 * <h1>
 *     Show Service
 * </h1>
 * <p>
 *     Service Layer for the Show
 *     to Create, Get and Delete
 *     the details of the Show
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
    ShowResponseDTO createShow(ShowDTO showDTO) throws AlreadyExistException, NotFoundException, NotAcceptableException;

    /**
     * <h1>
     *     cancelShow
     * </h1>
     * <p>
     *     Gets the id from the controller
     *     checks the given show is exist or not
     *     if exists the show get canceled else
     *     exception is thrown
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
     *     Gets all the shows for the particular movie
     *     By the name of the movie
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
     *     Gets the Show based on the id
     *     of the show if there is no
     *     show for the id then exception is
     *     thrown
     * </p>
     *
     * @param id - Holds the id of the Show
     * @return showResponseDTo - Holds the details of the show in response dto
     * @throws NotFoundException - Occurs when there is no show for the given id
     */
    ShowResponseDTO getShowById(Long id) throws NotFoundException;

    /**
     * <h1>
     *     cancelShowsForRemovedScreen
     * </h1>
     * <p>
     *     Cancels the shows for the screen
     *     which removed from the theater
     * </p>
     * @param screen - Holds the details of the screen which got removed from the screen
     * @return
     */
    boolean cancelShowsForRemovedScreen(Screen screen);
}
