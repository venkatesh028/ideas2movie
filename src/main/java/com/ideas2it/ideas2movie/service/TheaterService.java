/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import java.util.List;

import com.ideas2it.ideas2movie.model.Theater;
import com.ideas2it.ideas2movie.dto.TheaterDTO;
import com.ideas2it.ideas2movie.dto.responsedto.TheaterResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;


/**
 * <h1>
 *     TheaterService
 * </h1>
 * <p>
 *     TheaterService provides the Methods for Theater CRUD Operation
 *     and throws an Exceptions when occurred
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since 07-01-2023
 */
public interface TheaterService {

    /**
     * <h1>
     *     addTheater
     * </h1>
     * <p>
     *     Create Theater details and Validate the theater name, city and
     *     area is already exist in ideas2movie, if not then add the
     *     theater details to ideas2movie and throw Exception when occur.
     * </p>
     *
     * @param theaterDto - Holds the details of the theater.
     * @return TheaterResponseDto - Holds the created theater details.
     * @throws AlreadyExistException - Occur when try to add the theater name, city, area
     *                               which is already registered with same details in ideas2movie
     */
    TheaterResponseDTO addTheater(TheaterDTO theaterDto)
            throws AlreadyExistException;

    /**
     * <h1>
     *     getAllTheaters
     * </h1>
     * <p>
     *     Get all the Theaters which registered in ideas2movie
     * </p>
     *
     * @return TheaterResponseDto - Holds details of Theaters which is existing in ideas2movie
     * @throws NoContentException - occur when no theater is existing in ides2movie
     */
    List<TheaterResponseDTO> getAllTheaters() throws
            NoContentException;

    /**
     * <h1>
     *     getTheaterById
     * </h1>
     * <p>
     *     Get the Theater details on given Theater Id, if id not
     *     exist in ideas2movie then throws an Exception.
     * </p>
     *
     * @param id - ID of the theater to be fetched from ideas2movie
     * @return TheaterResponseDto - Holds existing theater details
     * @throws NotFoundException - Occur when no theater details is existing
                              in ideas2movie on a given id
     */
    TheaterResponseDTO getTheaterById(Long id) throws
            NotFoundException;

    /**
     * <h1>
     *      getTheaterForScreenById
     * </h1>
     * <p>
     *     Get the Theater details on given Theater Id for the screen, if id not
     *     exist in ideas2movie then throws an Exception.
     * </p>
     *
     * @param id - ID of the theater to be fetched from ideas2movie
     * @return theater - Holds existing theater details
     * @throws NotFoundException - Occur when no theater is existing
     *                     in ideas2movie on a given id
     */
    Theater getTheaterForScreenById(Long id)
            throws NotFoundException;

    /**
     * <h1>
     *     updateTheater
     * </h1>
     * <p>
     *     Update Theater details and Validate the theater name, city and
     *     area is already exist in ideas2movie, if not then update the
     *     theater details to ideas2movie and throw Exception when occur.
     * </p>
     *
     * @param id - ID of the theater to be updated
     * @param theaterDTO - Holds theater details to be updated
     * @return TheaterResponseDto - Holds the  updated theater details
     * @throws NotFoundException - If the given theater id is not exist in ideas2movie
     * @throws AlreadyExistException - Occur when try to update the theater name, city, area which is already
     *                                  registered with same details in ideas2movie
     */
    TheaterResponseDTO updateTheater(Long id, TheaterDTO theaterDTO)
            throws NotFoundException, AlreadyExistException;

    /**
     * <h1>
     *     removeTheater
     * </h1>
     * <p>
     *     Remove the Theater details based on Theater Id
     *     if Id exist remove the Theater else throw an
     *     Exception.
     * </p>
     *
     * @param id - ID of theater to be removed.
     * @return boolean - If theater remove successfully return true or else false
     * @throws NotFoundException - Occur when id not exist in ideas2movie.
     */
    boolean removeTheater(Long id) throws NotFoundException;
}