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

/**
 * <h2>
 *     Show Service
 * </h2>
 * <p>
 *     ShowService provides the Methods for Show Operation used to handle the Show For Screen
 *     like Creating an shows, Getting the Details of the Shows, and Cancel the Shows
 *     and throws an Exceptions when occurred
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
     *     creates Show for the Screen Based on the information provided
     *     And checks the Show is already exist for the Screen
     *     with show timing, Date and screen ID of the show if there
     *     is a show in that screen with the same timing, Date then exception is thrown
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
     *     Cancels the Show based on the id of the show for a Screen
     *     and checks whether the show is already Exist or not
     *     then change the status of the show if show is not exists
     *     then throws an Exception
     * </p>
     *
     * @param id - Holds the id of the show
     * @return message - Holds the canceled successfully message
     * @throws NotFoundException - Occurs When there is no show with given id
     */
    boolean cancelShow(Long id) throws NotFoundException;

    /**
     * <h1>
     *     getAllShowsByMovieName
     * </h1>
     * <p>
     *     Gets all the Shows for particular movie based on the
     *     name of the movie if there is no shows for that movie
     *     then exception is thrown
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
     *     Gets the Show based on the ID of the Show, Checks
     *     whether the show is Exist or not then returns the Details of the Show
     *     or throws an Exception
     * </p>
     *
     * @param id - Holds the id of the Show
     * @return showResponseDTo - Holds the details of the show in response dto
     * @throws NotFoundException - Occurs when there is no show for the given id
     */
    ShowResponseDTO getShowById(Long id) throws NotFoundException;

    /**
     * <h1>
     *     getAllShowsForScreen
     * </h1>
     * <p>
     *     Gets All Shows screening in a particular
     *     screen based on id of the screen if there
     *     is no shows screening then exception is thrown
     * </p>
     * @param id - Holds the id of the screen
     * @return shows - Holds the list of shows screening in particular screen
     * @throws NoContentException - Occurs When there is no show is screening in the screen
     */
    List<ShowResponseDTO> getAllShowsByScreenId(Long id) throws NoContentException;
}
