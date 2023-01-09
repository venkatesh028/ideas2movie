/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.ScreenDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ScreenResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Screen;

/**
 * <h1>
 *     Screen Service
 * </h1>
 * <p>
 *     Service Layer for the Screen
 *     to Create, Update, Get
 *     and Delete the details of the Screen
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
public interface ScreenService {

    /**
     * <h1>
     *     Create Screen
     * </h1>
     * <p>
     *     Create Screen for the Theater
     *     By getting the screenDTO from the controller
     *     And checks the Screen is already exist for the theater
     *     with name and theater id of the screen     *
     * </p>
     * @param screenDTO - Holds the Details of the Screen
     * @return screenResponseDTO - Holds the Response Details of the Screen
     * @throws NotFoundException - Occurs When there is no theater in that id
     * @throws AlreadyExistException- Occurs when the screen name is already exist in that theater
     */
    ScreenResponseDTO createScreen(ScreenDTO screenDTO) throws NotFoundException, AlreadyExistException;
    ScreenResponseDTO updateScreen(Long id, ScreenDTO screenDTO) throws AlreadyExistException, NotFoundException;
    String deleteScreen(Long id) throws NotFoundException;
    Screen getScreenById(Long id) throws NotFoundException;

}
