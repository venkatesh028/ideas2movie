/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.ideas2movie.dto.UserDTO;
import com.ideas2it.ideas2movie.dto.responsedto.UserResponseDTO;
import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.service.UserService;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     UserController
 * </h1>
 * <p>
 *     UserController provides the RESTful endpoints to handle CRUD operations
 *     for the User of the Application and validates the Information of the UserDTO
 *     according to the Validation Constraints and throws an Exception when occurred
 *     and returns the Details of the User and Http Status
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper mapper = new ModelMapper();

    /**
     * <h1>
     *     User Controller Constructor
     * </h1>
     * <p>
     *     Used to initialize the Services for calling the Operation performers of Service
     *     and also achieves the Autowiring
     * </p>
     *
     * @param userService - An instance of the User Service
     */
    public UserController(UserService userService) {

        this.userService = userService;
    }

    /**
     * <h1>
     *     createUser
     * </h1>
     * <p>
     *     Create an Account for a User by validates UserDTO according to Validation Constraints
     *     If Details of the User is Not Valid throws Exception else Process the Request
     *     and Returns the ResponseEntity with Http Status CREATED and Details of the User
     * </p>
     *
     * @param userDTO - holds the Details of the User
     * @return ResponseEntity - Holds the UserResponseDTO and Http Status CREATED
     * @throws AlreadyExistException - when the Details of the User is Already Present
     */
    @PostMapping
    public ResponseEntity<UserResponseDTO> createAccount(@Valid @RequestBody UserDTO userDTO)
            throws AlreadyExistException, BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
    }

    /**
     * <h1>
     *     getUserById
     * </h1>
     * <p>
     *     Retrieves the Details of the User By the ID of the User
     *     by process the request If the User is Not found then throws an Exception
     *     otherwise returns the ResponseEntity with Http Status OK and Details of the User
     * </p>
     *
     * @param id - ID of the User to get the User
     * @return ResponseEntity - Holds the UserResponseDTO and Http Status Ok
     * @throws NotFoundException - throws when user Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("id") Long id)
            throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    /**
     * <h1>
     *     updateUser
     * </h1>
     * <p>
     *     Updates the Details of the User by the ID and UserDTO and validates according
     *     to Validation Constraints If User Details are not Valid the throws an Exception
     *     else process the request and returns the ResponseEntity with Http Status OK
     *     and updated Details of the User or throws an Exception If User not Found
     * </p>
     *
     * @param id -ID of the User to update the Details of the User
     * @param userDTO - holds the Details of the User
     * @return ResponseEntity - Holds the UserResponseDTO and Http Status OK
     * @throws NotFoundException - when user Not Found
     * @throws AlreadyExistException - when User's Name or Phone Number Already Exist
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable("id") Long id,
                                                      @Valid @RequestBody UserDTO userDTO)
            throws NotFoundException, AlreadyExistException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, userDTO));
    }

    /**
     * <h1>
     *     deactivateAccount
     * </h1>
     * <p>
     *     Deactivates the User Account By the ID of the User and returns the ResponseEntity
     *     with Http status Ok and a String, If User is not found then throws an Exception
     * </p>
     *
     * @param id - ID of the User to Delete the User
     * @return ResponseEntity - Holds the String and Http Status OK
     * @throws NotFoundException - throws when user Not Found
     */
    @DeleteMapping("/{id}")

    public ResponseEntity<String> deactivateAccount(@PathVariable("id") Long id) throws NotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }
}
