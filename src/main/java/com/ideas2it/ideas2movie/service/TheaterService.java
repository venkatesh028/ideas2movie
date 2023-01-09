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
     * <p>
     * To create Theater Details
     * </p>
     *
     * @param theaterDto it contains details of the theater.
     * @return TheaterDto
     */
    Optional<TheaterResponseDTO> addTheater(TheaterDTO theaterDto)
            throws AlreadyExistException;

    /**
     * <p>
     * T0 List all the Theater Names which is currently running.
     * </p>
     *
     * @return List<TheaterDto>
     */
    List<TheaterResponseDTO> getAllTheaters() throws
            NotFoundException;

    /**
     * <p>
     * To get the Theater Details based on theater id.
     * </p>
     *
     * @param id it contains theater id
     * @return TheaterDto
     */
    TheaterResponseDTO getTheaterById(Long id) throws
            NotFoundException;

    /**
     * <p>
     * Check the given theater id exist in ideas2movie if it exist
     * To get the Theater Details for screen based on theater id.
     * </p>
     *
     * @param id it contains theater id
     * @return TheaterDto
     */
    Theater getTheaterForScreenById(Long id)
            throws NotFoundException;

    /**
     * <p>
     * Check the given theater id exist in ideas2movie if it exist
     * update the Theater and send the updated theaterResponseDTO.
     * </p>
     *
     * @param id - id of the theater to be updated
     * @param theaterDTO it contains theater details
     * @return List<TheaterDto>
     * @throws NotFoundException - if the given theater id is not exist in ideas2movie
     * @throws AlreadyExistException - occur when try to update the theater name and city
     *                             with another theater name and city which already exist
     *                             in ideas2movie
     */
    TheaterResponseDTO updateTheater(Long id, TheaterDTO theaterDTO)
            throws NotFoundException, AlreadyExistException;

    /**
     * <p>
     * Check the given theater id exist in ideas2movie if it exist delete the Theater
     * and send the deleted success message if not exist send the failed to delete message.
     * </p>
     *
     * @param id of theater to be deleted.
     * @return delete message if theater deleted successfully
     * @throws NotFoundException - occur when id exist and fail to delete.
     */
    String deleteTheater(Long id) throws NotFoundException;
}