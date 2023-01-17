/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.ideas2it.ideas2movie.model.CastAndCrew;
import com.ideas2it.ideas2movie.model.Movie;

/**
 * <h1>
 *     CastAndCrewRepository
 * <h1/>
 * <p>
 *     To save and retrieve the cast and crew details in ideas2movie
 *     by using jpa repository.
 * </p>
 *
 * @author  YOGESHWAR S
 * @version 1.0
 * @since   10.01.2023
 */
@Repository
public interface CastAndCrewRepository extends JpaRepository<CastAndCrew, Long> {
    boolean existsById(Long id);
}
