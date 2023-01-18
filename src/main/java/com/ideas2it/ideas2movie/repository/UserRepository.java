/*
 * Copyright 2022 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.ideas2movie.model.User;

/**
 * <h2>
 *     UserRepository
 * </h2>
 * <p>
 *     UserRepository provides the CRUD of the User by extending JPARepository
 *     like Saving, Updating and Fetching the Details of the User
 *     and contains the Custom methods to Check whether the user is present for the given Name or Phone Number
 *     and to Fetch the Details od the User by Phone Number
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * <h1>
     *     existsByPhoneNumber
     * </h1>
     * <p>
     *     Checks whether there is a User in the repository for the given phone number or not
     *     and return the Boolean value accordingly
     * </p>
     *
     * @param phoneNumber - Phone Number of the User
     * @return boolean - true If phone number id exist else false
     */
    boolean existsByPhoneNumber(String phoneNumber);

    /**
     * <h1>
     *     existsByName
     * </h1>
     * <p>
     *     Checks whether there is a User in the repository for the given Name or not
     *     and returns the boolean value accordingly
     * </p>
     *
     * @param name - Name of the User
     * @return boolean - true If Name is exist else false
     */
    boolean existsByName(String name);

    /**
     * <h1>
     *     findByPhoneNumber
     * </h1>
     * <p>
     *     Retrieves the Details of the User associated with the given Phone Number
     * </p>
     *
     * @param phoneNumber - Phone Number of the User to Fetch Details
     * @return User - Holds the Details of the User or null
     */
    User findByPhoneNumber(String phoneNumber);
}

