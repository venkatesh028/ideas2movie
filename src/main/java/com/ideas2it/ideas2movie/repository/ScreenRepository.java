/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.ideas2movie.model.Screen;

/**
 * <h1>
 *     ScreenRepository
 * </h1>
 * <p>
 *     Repository of  the screen
 *     to save and fetch the details of
 *     screen using the JPARepository
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
     *
     * @param screenName - Holds the name of the screen
     * @param theaterId - Holds the id of the theater
     * @return boolean -  Holds status of screen exists
     */
    boolean existsScreenByNameAndTheaterId(String screenName, Long theaterId);

    /**
     * <h1>
     *     findByIdAndTheaterId
     * </h1>
     * <p>
     *     Fetch the Screen for the particular theater
     *     By using the screenId and theaterId
     * </p>
     *
     * @param screenId - Holds the id of the screen
     * @param theaterId - Holds the id of the theater
     * @return Screen - Holds the details of the screen
     */
    Optional<Screen> findByIdAndTheaterId(Long screenId, Long theaterId);

    /**
     * <h1>
     *     findByIdAndTheaterId
     * </h1>
     * <p>
     *     Fetch the Screen for the particular theater
     *     By using the screenId and theaterId
     * </p>
     *
     * @param screenName - Holds the name of the screen
     * @param theaterId - Holds the id of the theater
     * @return Screen - Holds the details of the screen
     */
    Optional<Screen> findByNameAndTheaterId(String screenName, Long theaterId);
}
