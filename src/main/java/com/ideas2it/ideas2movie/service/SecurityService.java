/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <h2>
 *     SecurityService
 * </h2>
 * <p>
 *     Provides the Method to load the user based on the provided
 *     username
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 17/01/2023
 */
public interface SecurityService extends UserDetailsService {

    /**
     * <h1>
     *     loadUserByUsername
     * </h1>
     * <p>
     *     Gets the user based on te username of the user
     *     if there is no user for the given username then
     *     exception is thrown
     * </p>
     * @param username - username of the user
     * @return UserDetails - Holds the details of the user
     * @throws UsernameNotFoundException - Occurs when there is no user for the given username
     */
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
