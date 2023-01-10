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
 *     UserService
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
     *     createUser
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
     * @return UserResponseDTO - Holds the Created User Details
     * @throws AlreadyExistException - when User's Name or Phone Number Already Exist
     * @throws NotFoundException - when Role Not Found
     */
    UserResponseDTO createUser(UserDTO userDTO) throws AlreadyExistException, NotFoundException;

    /**
     * <h1>
     *     getUserByID
     * </h1>
     * <p>
     *     Gets the User By getting the ID of the User
     *     from the Controller
     *     and checks whether the User is present or Not
     *     If present then returns the User Details
     *     Otherwise throws Exception
     * </p>
     *
     * @param id - ID of the User to get the Details
     * @return UserResponseDTO - Holds the Details of User
     * @throws NotFoundException - when User not found
     */
    UserResponseDTO getUserById(Long id) throws NotFoundException;

    /**
     * <h1>
     *      updateUser
     * </h1>
     * <p>
     *      Updates the User
     *      by getting the UserDTO from the Controller
     *      and checks whether the User name
     *      and Phone Number is already Exists or Not
     *      If Exist then throws an Exception
     * </p>
     *
     * @param id - ID of the User to Update the user Details
     * @param userDTO - reference Variable which holds the Details of the User
     * @return UserResponseDTO - Holds the Updated User Details
     * @throws AlreadyExistException - when User's Name or Phone Number Already Exist
     * @throws NotFoundException     - when Role Not Found
     */
    UserResponseDTO updateUser(Long id, UserDTO userDTO) throws NotFoundException, AlreadyExistException;

    /**
     * <h1>
     *     deleteUser
     * </h1>
     * <p>
     *     Deletes the User
     *     by getting the ID of the User from Controller
     *     and checks whether the User is present or Not
     *     If present then deletes the User Details
     *     Otherwise throws Exception
     * </p>
     *
     * @param id - ID of the User to delete the Details
     * @return String - Success message of Deletion
     * @throws NotFoundException - when User Not Found
     */
    String deleteUser(Long id) throws NotFoundException;
}
