/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

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
import com.ideas2it.ideas2movie.service.UserService;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     UserController
 * </h1>
 * <p>
 *     Gets the Input as a Request from the Client and Validates them
 *     for Create, Update, and Get the Details of the User by Instance of the userService
 *     and used to handle and mapping the request to the appropriate function
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
     *     Gets the RequestBody for creating the user and Validates according to Validation Constrains
     *     and process the request by sending to UserService and returns the UserResponseDTO and Http Status
     *     or throws an Exception when occurred
     * </p>
     *
     * @param userDTO - holds the Details of the User
     * @return ResponseEntity - Holds the UserResponseDTO and Http Status
     * @throws AlreadyExistException - Throws when User Detail is Already Exist
     * @throws NotFoundException - Throws when Role Not Found
     */
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserDTO userDTO)
                                                                throws AlreadyExistException,
                                                                        NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(userDTO));
    }

    /**
     * <h1>
     *     getUserById
     * </h1>
     * <p>
     *     Gets the PathVariable to Get the Details of the User by ID of the User
     *     and process the request by sending to UserService and returns the UserResponseDTO and Http Status
     *     or throws an exception when occurred
     * </p>
     *
     * @param id - ID of the User to get the User
     * @return ResponseEntity - Holds the UserResponseDTO and Http Status
     * @throws NotFoundException - throws when user Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    /**
     * <h1>
     *     Update User
     * </h1>
     * <p>
     *     Gets the PathVariable and RequestBody to update the Details of the User and Validates according
     *     to Validation Constraints and process the Request by sending to UserService
     *     and returns the UserResponseDTO and Http Status or throws an Exception when occurred
     * </p>
     *
     * @param id -ID of the User to update the Details of the User
     * @param userDTO - holds the Details of the User
     * @return ResponseEntity - Holds the UserResponseDTO and Http Status
     * @throws NotFoundException - when user Not Found
     * @throws AlreadyExistException - when User's Name or Phone Number Already Exist
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) throws NotFoundException, AlreadyExistException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, userDTO));
    }

    /**
     * <h1>
     *     Delete User
     * </h1>
     * <p>
     *     Gets the PathVariable to Delete the Details of the User by ID of the User
     *     and process the Request by sending to UserService and returns the Message and Http Status
     *     or throws an Exception when occurred
     * </p>
     *
     * @param id - ID of the User to Delete the User
     * @return ResponseEntity - Holds the String and Http Status
     * @throws NotFoundException - throws when user Not Found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) throws NotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }
}
