/*
 * Copyright 2022 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;


import com.ideas2it.ideas2movie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>
 *     UserRepository
 * </h1>
 * <p>
 *     Repository of the User
 *     to save, Fetch, and update the details of the User
 *     By using the JPA Repository
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * <h1>
     * existsByPhoneNumber
     * </h1>
     * <p>
     * Checks and Returns the result
     * for phone number is Already Exist or Not
     * </p>
     *
     * @param phoneNumber - Phone Number to check isExist
     * @return isExist - Holds the response of isExist
     */
    boolean existsByPhoneNumber(String phoneNumber);

    /**
     * <h1>
     * existsByName
     * </h1>
     * <p>
     * Checks and Returns the result
     * for Name is Already Exist or Not
     * </p>
     *
     * @param name - Name to check Is Exist
     * @return isExist - Holds the response of isExist
     */
    boolean existsByName(String name);

    User findByPhoneNumber(String phoneNumber);
}

