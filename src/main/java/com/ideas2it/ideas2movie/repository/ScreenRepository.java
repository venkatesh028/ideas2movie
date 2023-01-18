/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.ideas2movie.model.Screen;

/**
 * <h1>
 *     ScreenRepository
 * </h1>
 * <p>
 *     ScreenRepository provides the CRUD of the Screen by extending JPARepository like Saving the Screen
 *     Updating the screen name and Fetching the details of the screen and contains the custom methods
 *     to check the existence of screen based on the name and theater id and to fetch the screen based on theater ID
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 10/01/2023
 */
@Repository
public interface ScreenRepository extends JpaRepository<Screen,Long> {

    /**
     *<h1>
     *     existsScreenByNameAndTheaterId
     *</h1>
     * <p>
     *     Checks the existence of screen in the repository based on the given name and theater id
     *     And return the boolean accordingly
     * </p>
     *
     * @param screenName - Name of the screen
     * @param theaterId - ID of the theater
     * @return boolean -  true if screen exists else false
     */
    boolean existsScreenByNameAndTheaterId(String screenName, Long theaterId);

    /**
     * <h1>
     *     findByIdAndTheaterId
     * </h1>
     * <p>
     *     Fetch the Screen for the particular theater
     *     Based on the screen ID and theater ID
     * </p>
     *
     * @param screenId - ID of the screen
     * @param theaterId - ID of the theater
     * @return Screen - Holds the details of the screen
     */
    Optional<Screen> findByIdAndTheaterId(Long screenId, Long theaterId);

    /**
     * <h1>
     *     findByIdAndTheaterId
     * </h1>
     * <p>
     *     Fetch the Screen for the particular theater
     *     By using the screen name and theater ID
     * </p>
     *
     * @param screenName - Name of the screen
     * @param theaterId - ID of the theater
     * @return Screen - Holds the details of the screen
     */
    Optional<Screen> findByNameAndTheaterId(String screenName, Long theaterId);

    /**
     * <h1>
     *     findALLByTheaterId
     * </h1>
     * <p>
     *     Fetch All the screen for the particular theater
     *     based on the id of the theater
     * </p>
     * @param id - ID of the theater
     * @return screens - Holds the list of screen for the particular theater
     */
    List<Screen> findAllByTheaterId(Long id);
}
