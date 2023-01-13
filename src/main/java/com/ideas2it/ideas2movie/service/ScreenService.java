/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import java.util.List;

import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.dto.ScreenDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ScreenResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     Screen Service
 * </h1>
 * <p>
 *     Service Layer for the Screen
 *     to Create, Update, Get
 *     and remove the details of the Screen
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
public interface ScreenService {

    /**
     * <h1>
     *     createScreen
     * </h1>
     * <p>
     *     creates Screen for the Theater By getting the screenDTO from the controller
     *     And checks the Screen is already exist for the theater
     *     with screen name and theater id of the screen if there
     *     is a screen in that theater with the same name then exception is thrown
     * </p>
     *
     * @param screenDTO - Holds the Details of the Screen
     * @return screenResponseDTO - Holds the Response Details of the Screen
     * @throws AlreadyExistException- Occurs when the screen name is already exist in that theater
     * @throws BadRequestException - Occurs When there is no theater in that id
     */
    ScreenResponseDTO createScreen(ScreenDTO screenDTO) throws AlreadyExistException, BadRequestException;

    /**
     * <h1>
     *     updateScreen
     * </h1>
     * <p>
     *     Updates Screen for the Theater
     *     By getting ScreenDTO and id from the Controller
     *     And checks the Screen is already exist for the
     *     theater with screen name and theater id of the screen
     *     if there is a screen in that theater with the same name
     *     then exception is thrown
     * </p>
     *
     * @param id  - Holds the id of the Screen
     * @param screenDTO - Holds the details of screen need to updated
     * @return screenResponseDTO - Holds the updated screen details of screen
     * @throws AlreadyExistException - Occurs When there is a screen with screen name in the theater
     * @throws NotFoundException - Occurs When there is No screen with given id
     */
    ScreenResponseDTO updateScreen(Long id, ScreenDTO screenDTO) throws AlreadyExistException, NotFoundException,
            BadRequestException;

    /**
     * <h1>
     *     deleteScreen
     * </h1>
     * <p>
     *      Removes the Screen based on the id of the screen
     *      by getting id from the controller if there is no screen
     *      for the id then Exception is thrown
     * </p>
     *
     * @param id - Holds the id of the Screen
     * @return message - Holds the success message after changing the active status of screen
     * @throws NotFoundException - Occurs When there is no screen for the given id
     */
    String removeScreen(Long id) throws NotFoundException;

    /**
     * <h1>
     *     getScreenById
     * </h1>
     * <p>
     *     Gets the Screen based on the
     *     id if the screen is not present then
     *     exception is thrown
     * </p>
     *
     * @param id - Holds the id of the screen
     * @return screen - Holds the details of the screen
     * @throws NotFoundException - Occurs When there is no screen for the given id
     */
    Screen getScreenById(Long id) throws BadRequestException, NotFoundException;

    List<ScreenResponseDTO> getScreensByTheaterId(Long id) throws NoContentException;
}
