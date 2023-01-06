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

public interface TheaterService {
    /**
     * <p>
     * To create Theater Details
     * </p>
     *
     * @param theaterDto it contains details of the theater.
     * @return TheaterDto
     */
    Optional<TheaterDTO> createTheater(TheaterDTO theaterDto)
            throws AlreadyExistException;

    /**
     * <p>
     * T0 List all the Theater Names which is currently running.
     * </p>
     *
     * @return List<TheaterDto>
     */
    List<TheaterResponseDTO> getAllTheater() throws NotFoundException;

    /**
     * <p>
     * To get the Theater Details based on theater id.
     * </p>
     *
     * @param id it contains theater id
     * @return TheaterDto
     */
    TheaterResponseDTO getTheaterById(Long id) throws NotFoundException;


    /**
     * <p>
     * To update the Theater Details
     * </p>
     *
     * @param theaterDto it contains theater details
     * @return List<TheaterDto>
     */
    TheaterDTO updateTheater(TheaterDTO theaterDto) throws NotFoundException;
}