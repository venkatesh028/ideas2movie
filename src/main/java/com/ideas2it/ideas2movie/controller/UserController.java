/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import com.ideas2it.ideas2movie.dto.UserDTO;
import com.ideas2it.ideas2movie.dto.responsedto.UserResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.ideas2movie.service.UserService;

/**
 * <h1>
 *     User Controller
 * </h1>
 * <p>
 *     Gets the Input parameter as a Request from then Client
 *     for Create, Update, and Get the User
 *     by sending those parameter and object
 *     to perform Business Logics on them
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
     *     Used to Achieve the Autowiring for User Service
     * </p>
     *
     * @param userService - reference variable of the User Service
     */
    public UserController(UserService userService) {

        this.userService = userService;
    }

    /**
     * <h1>
     *     Create User
     * </h1>
     * <p>
     *     Adds the User by Getting the Input
     *     for the User from the Client
     * </p>
     * @param userDTO - holds the Details of the User
     * @return ResponseEntity - Holds the User Response DTO and Http Status
     * @throws AlreadyExistException - Throws when User Already Exist
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
     *     Get User By Id
     * </h1>
     * <p>
     *     Gets the User By Id
     *     by sending the ID to Service
     *     where it will check the user is present or not
     * </p>
     * @param id - id of the User to get the User
     * @return ResponseEntity - Holds the User Response DTO and Http Status
     * @throws NotFoundException - throws when user Not Found
     */
    public ResponseEntity<UserResponseDTO> getUserById(@RequestParam Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }
}
