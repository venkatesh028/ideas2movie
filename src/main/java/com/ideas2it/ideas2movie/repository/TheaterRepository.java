/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.ideas2movie.model.Theater;
import com.ideas2it.ideas2movie.util.enums.City;

/**
 * <h1>
 *     TheaterRepository
 * <h1/>
 * <p>
 *     To save and retrieve the theater details in ideas2movie
 *     by using jpa repository.
 * </p>
 *
 * @author  YOGESHWAR S
 * @version 1.0
 * @since   10.01.2023
 */
@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

    /**
     * <h1>
     *     existsByCity
     * </h1>
     * <p>
     *     Getting the city name from theater service and
     *     check the given city name exist in ideas2movie
     *     if it exist return true or else false.
     * </p>
     *
     * @param city - name of city to be checked if it exists or not.
     * @return true - if city name exist or else return false
     */
    boolean existsByCity(City city);

    /**
     * <h1>
     *     existsByTheaterName
     * </h1>
     * <p>
     *     Getting the theater name from theater service and
     *     check the given theater name exist in ideas2movie
     *     if it exist return true or else false.
     * </p>
     *
     * @param theaterName - name of theater to be checked if it exists or not.
     * @return true - if theater name exist or else return false
     */
    boolean existsByTheaterName(String theaterName);

    /**
     * <h1>
     *     existsByArea
     * </h1>
     * <p>
     *     Getting the area name from theater service and
     *     check the given area name exist in ideas2movie
     *     if it exist return true or else false.
     * </p>
     *
     * @param area - name of area to be checked if it exists or not.
     * @return true - if  name exist or else return false
     */
    boolean existsByArea(String area);

    boolean existsById(Long id);
}
