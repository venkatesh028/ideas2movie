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
 * <h2>
 *     TheaterRepository
 * </h1>
 * <p>
 *     Represent the Theater repository to save, fetch the theater details
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
     *     Check the Details of the Theater exist in ideas2movie
     *     by using the City Name
     * </p>
     *
     * @param city - Name of city to be checked if it exists or not.
     * @return boolean - If city name exist return true or else false
     */
    boolean existsByCity(City city);

    /**
     * <h1>
     *     existsByTheaterName
     * </h1>
     * <p>
     *     Check the Details of the Theater exist in ideas2movie
     *     by using the Theater Name
     * </p>
     *
     * @param theaterName - Name of theater to be checked if it exists or not.
     * @return boolean - If theater name exist return true or else  false
     */
    boolean existsByTheaterName(String theaterName);

    /**
     * <h1>
     *     existsByArea
     * </h1>
     * <p>
     *     Check the Details of the Theater exist in ideas2movie
     *     by using the Area Name
     * </p>
     *
     * @param area - Name of area to be checked if it exists or not.
     * @return boolean - If area name exist return true or else  false
     */
    boolean existsByArea(String area);
}
