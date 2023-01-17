/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import java.util.List;
import java.util.Optional;

import com.ideas2it.ideas2movie.dto.TheaterDTO;
import com.ideas2it.ideas2movie.dto.responsedto.TheaterResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Theater;

/**
 * <h1>
 *     Theater Service Interface
 * </h1>
 * <p>
 *     Service Layer for the Theater
 *     to Create, and Get the details of the theater
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
     *     Getting the theaterDTO from theater controller and
     *     Check the given theater name, city and area is
     *     already exist in ideas2movie, if not then add the
     *     theater details to ideas2movie.
     * </p>
     *
     * @param theaterDto it contains details of the theater to be added to ideas2movie.
     * @return TheaterResponseDto - after store in ideas2movie to give a response as theater details.
     * @throws AlreadyExistException - occur when try to add the theater name, city, area which is already
     *                               registered with same details in ideas2movie
     */
    Optional<TheaterResponseDTO> addTheater(TheaterDTO theaterDto)
            throws AlreadyExistException;

    /**
     * <h1>
     *     getAllTheaters
     * </h1>
     * <p>
     *     check the status of theaters if theater is active then
     *     Get all the Theaters which registered in ideas2movie
     * </p>
     *
     * @return List<TheaterResponseDto> gives a response of all theater details
     * @throws NoContentException - occur when no theater is existing in ides2movie
     */
    List<TheaterResponseDTO> getAllTheaters() throws
            NoContentException;

    /**
     * <h1>
     *     getTheaterById
     * </h1>
     * <p>
     *     Getting the theater id from theater controller and
     *     check the given theater id is exist in ideas2movie
     *     if it exist get the Theater Details based on id.
     * </p>
     *
     * @param id - id of the theater to be fetched from ideas2movie
     * @return TheaterResponseDto - gives a response of theater details based on theater id
     * @throws NotFoundException - occur when no theater is existing in ideas2movie on a given id
     */
    TheaterResponseDTO getTheaterById(Long id) throws
            NotFoundException;

    /**
     * <h1>
     *      getTheaterForScreenById
     * </h1>
     * <p>
     *     Getting the movie id from the theater controller
     *     Check the given theater id exist in ideas2movie if it exist
     *     get the Theater Details for screen based on theater id.
     * </p>
     *
     * @param id - id of the theater to be fetched from ideas2movie
     * @return existingTheater - gives a theater details based on theater id
     * @throws NotFoundException -  occur when no theater is existing
     *                     in ideas2movie on a given id
     */
    Theater getTheaterForScreenById(Long id)
            throws NotFoundException;

    /**
     * <h1>
     *     updateTheater
     * </h1>
     * <p>
     *     Getting the movie id and theaterDTO object from the
     *     theater controller and Check the given theater id exist
     *     in ideas2movie if it exist then update the Theater and
     *     send the updated theaterResponseDTO.
     * </p>
     *
     * @param id - id of the theater to be updated
     * @param theaterDTO it contains theater details
     * @return TheaterResponseDto - gives a response of updated theater details based on id
     * @throws NotFoundException - if the given theater id is not exist in ideas2movie
     * @throws AlreadyExistException - occur when try to update the theater name, city, area which is already
     *                                  registered with same details in ideas2movie
     */
    TheaterResponseDTO updateTheater(Long id, TheaterDTO theaterDTO)
            throws NotFoundException, AlreadyExistException;

    /**
     * <h1>
     *     Delete theater
     * </h1>
     * <p>
     *     Getting theater id from theater controller
     *     Check the given theater id exist in ideas2movie
     *     if it exist delete the Theater and
     *     send the deleted success message.
     * </p>
     *
     * @param id of theater to be deleted.
     * @return delete message if theater deleted successfully
     * @throws NotFoundException - occur when id is not exist in ideas2movie.
     */
    boolean deleteTheater(Long id) throws NotFoundException;
}