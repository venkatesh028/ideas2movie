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
 *     CastAndCrewService
 * </h1>
 * <p>
 *     CastAndCrewService provides the Methods for CastAndCrewService
 *     CRUD Operation and throws an Exceptions when occurred.
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since 06-01-2023
 */
public interface CastAndCrewService {

    /**
     * <h1>
     *     addCastAndCrew
     * </h1>
     * <p>
     *     Create the CastAndCrew details and add the CastAndCrew details
     *     in ideas2movie.
     * </p>
     *
     * @param castAndCrewDTO - Holds details of the castAndCrew to be added in ideas2movie.
     * @return CastAndCrewResponseDto - Holds the created CastAndCrew details.
     */
    CastAndCrewResponseDTO addCastAndCrew(CastAndCrewDTO castAndCrewDTO);

    /**
     * <h1>
     *     getCastAndCrewById
     * </h1>
     * <p>
     *     Get the CastAndCrew details on given CastAndCrew Id, if id not
     *     exist in ideas2movie then throws an Exception.
     * </p>
     *
     * @param id - ID of the CastAndCrew to be fetched from ideas2movie
     * @return CastAndCrewResponseDto - Holds fetched CastAndCrew details of a CastAndCrew id
     * @throws NotFoundException - Occur when no CastAndCrew details is existing
     *                         in ideas2movie on a given id
     */
    CastAndCrewResponseDTO getCastAndCrewById(Long id)
            throws  NotFoundException;

    /**
     * <h1>
     *     updateCastAndCrew
     * </h1>
     * <p>
     * <p>
     *     Update CastAndCrew details and add the updated CastAndCrew
     *     details to ideas2movie and throws Exception when occur.
     * </p>
     *
     * @param id - ID of the CastAndCrew to be Updated
     * @return CastAndCrewResponseDto - Holds the Updated CastAndCrew details.
     * @throws NotFoundException - occur when id is not exist in ideas2movie.
     */
    CastAndCrewResponseDTO updateCastAndCrew(Long id,
            CastAndCrewDTO castAndCrewDTO) throws NotFoundException;

    /**
     * <h1>
     *     deleteCastAndCrew
     * </h1>
     * <p>
     *     Delete the CastAndCrew details based on CastAndCrew Id
     *     if Id exist delete the CastAndCrew else throw an
     *     Exception.
     * </p>
     *
     * @param id - ID of CastAndCrew to be deleted.
     * @return boolean - If CastAndCrew deleted successfully return true or else false
     * @throws NotFoundException - Occur when id not exist in ideas2movie.
     */
    boolean deleteCastAndCrew(Long id) throws NotFoundException;
}
