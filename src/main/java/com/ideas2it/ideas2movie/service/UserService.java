/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.UserDTO;
import com.ideas2it.ideas2movie.dto.responsedto.UserResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h2>
 *     UserService
 * </h2>
 * <p>
 *     UserService provides the Methods for User CRUD Operation used to handle the User Account
 *     like Creating an Account for User, Getting the Details of the Account, and Deactivation
 *     of Account and throws an Exceptions when occurred
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
     *     Creates a new Account for the user based on the Information Provided
     *     By validates If the phone number and Name is Already Exist
     *     and If the role is Not exist throws an Exception throws an Exception
     *     returns the Details of the User
     * </p>
     *
     * @param userDTO - reference Variable which holds the Details of the User
     * @return UserResponseDTO - Holds the Created User Details
     * @throws AlreadyExistException - when User's Name or Phone Number Already Exist
     * @throws BadRequestException - when Role Not Found
     */
    UserResponseDTO createUser(UserDTO userDTO) throws AlreadyExistException, BadRequestException;
    /**
     * <h1>
     *     getUserByID
     * </h1>
     * <p>
     *     Retrieves the Details of the User By ID of the User
     *     and Validate If User is Not Exist throws an Exception else Returns the Details of the User
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
     *     Updates the Details of the User By ID of the User
     *     By validates If the user is Not Exist throws an Exception else
     *     validate If the Phone number and Name of the User Is already Exist throws an Exception
     *     else Updates the New Details of the User and return the Updated user
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
     *     Deactivates the Account of User by the ID of the User By validates
     *     If the User is not Exist throws the Exception else sets the Active Status of the User to False
     *     and returns a String for Conformation
     * </p>
     *
     * @param id - ID of the User to delete the Details
     * @return boolean -  status of the User is Deleted
     * @throws NotFoundException - when User Not Found
     */
    boolean deactivateUser(Long id) throws NotFoundException;
}
