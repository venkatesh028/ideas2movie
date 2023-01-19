/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.ideas2movie.model.CastAndCrew;

/**
 * <h2>
 *     CastAndCrewRepository
 * </h2>
 * <p>
 *     Repository of CastAndCrew, to save, fetch the cast and
 *     crew details by using jpa repository.
 * </p>
 *
 * @author  YOGESHWAR S
 * @version 1.0
 * @since   10.01.2023
 */
@Repository
public interface CastAndCrewRepository extends JpaRepository<CastAndCrew, Long> {

    /**
     * <h1>
     *     existsById
     * </h1>
     * <p>
     *     check the Details of the CastAndCrew exist
     *     in ideas2movie by using the CastAndCrew ID
     * </p>
     *
     * @param id - ID of the CastAndCrew to fetch the CastAndCrew Details
     * @return boolean - If CastAndCrew Details exist return true or else false
     */
    boolean existsById(Long id);
}
