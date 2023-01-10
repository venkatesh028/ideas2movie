/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.CastAndCrewDTO;
import com.ideas2it.ideas2movie.dto.responsedto.CastAndCrewResponseDTO;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     CastAndCrew Service Interface
 * </h1>
 * <p>
 *     Service Layer for the CastAndCrew
 *     to Create, and Get the CastAndCrew for  a movie
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since 06-01-2023
 */
public interface CastAndCrewService {

    /**
     * <h1>
     *     Add Cast and Crew for Movie
     * </h1>
     * <p>
     *     Getting castAndCrewDTO from CastAndCrew controller
     *     Add the Cast and Crew details to ideas2movie.
     * </p>
     *
     * @param castAndCrewDTO it contains details of the cast and crew.
     * @return castAndCrewResponseDto - after store in ideas2movie to
     *                         give a response as cast and crew details.
     */
    CastAndCrewResponseDTO addCastAndCrew(CastAndCrewDTO castAndCrewDTO);

    /**
     * <h1>
     *     Get cast and crew by movie id
     * </h1>
     * <p>
     *     Getting movie id from CastAndCrew controller and
     *     Check the given movie id for castAndCrew exist
     *     in ideas2movie, if it exist get the castAndCrew
     *     Details for movie.
     * </p>
     *
     * @param id - id of the movie to fetch the cast and crew details from ideas2movie
     * @return castAndCrewResponseDTO - gives a cast and crew details for the given movie
     * @throws NotFoundException -  occur when no castAndCrew is existing for given movieId, in ideas2movie
     */
    CastAndCrewResponseDTO getCastAndCrewByMovieId(Long id)
            throws  NotFoundException;

    /**
     * <h1>
     *     Update cast and crew details
     * </h1>
     * <p>
     *     Getting cast and crew id , castAndCrewDTO from
     *     CastAndCrew controller and update the cast, crew
     *     details and send the updated castAndCrewResponseDTO.
     * </p>
     *
     * @param id - id of the castAndCrew to be updated
     * @param castAndCrewDTO it contains cast and crew details to be updated.
     * @return castAndResponseDto - gives a response of updated cast and crew details based on id
     * @throws NotFoundException - occur when the given castAndCrew id is not exist in ideas2movie
     */
    CastAndCrewResponseDTO updateCastAndCrew(Long id,
            CastAndCrewDTO castAndCrewDTO) throws NotFoundException;

    /**
     * <h1>
     *     Delete cast and crew details
     * </h1>
     * <p>
     *     Getting cast and crew id, castAndCrewDTO object from
     *     CastAndCrew controller and Check the given castAndCrew id
     *     exist in ideas2movie if it exist, then delete the cast and crew,
     *     send the deleted success message.
     * </p>
     *
     * @param id of castAndCrew to be deleted.
     * @return delete message if castAndCrew deleted successfully
     * @throws NotFoundException - occur when id is not exist in ideas2movie.
     */
    String deleteCastAndCrew(Long id) throws NotFoundException;
}
