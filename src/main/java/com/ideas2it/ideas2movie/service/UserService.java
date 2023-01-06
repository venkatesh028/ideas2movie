/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.UserDTO;
import com.ideas2it.ideas2movie.dto.responsedto.UserResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     User Service
 * </h1>
 * <p>
 *     Service Layer for the User
 *     to Create, Update, Get
 *     and Delete the details of the user
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface UserService {
    /**
     * <h1>
     *     Create User
     * </h1>
     * <p>
     *     Creates the User
     *     by getting the UserDTO from the Controller
     *     and checks whether the User name
     *     and Phone Number is already Exists or Not
     *     If Exist then throws an Exception
     * </p>
     *
     * @param userDTO - reference Variable which holds the Details of the User
     * @return UserResposeDTO - Holds the Created User Details
     * @throws AlreadyExistException - occurs when User's Name or Phone Number Already Exist
     * @throws NotFoundException - occurs when Role Not Found
     */
    UserResponseDTO createUser(UserDTO userDTO) throws AlreadyExistException, NotFoundException;

    UserResponseDTO getUserById(Long id) throws NotFoundException;
}
