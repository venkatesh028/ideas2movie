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
    CastAndCrewResponseDTO addCastAndCrew(CastAndCrewDTO castAndCrewDTO);

    String deleteCastAndCrew(Long id) throws NotFoundException;

    CastAndCrewResponseDTO updateCastAndCrew(Long id,
          CastAndCrewDTO castAndCrewDTO) throws NotFoundException;

    CastAndCrewResponseDTO getCastAndCrewByMovieId(Long id) throws  NotFoundException;
}
