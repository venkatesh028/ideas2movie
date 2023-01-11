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
 *     Gets the Input parameter as a Request from then Client
 *     for Create, Update, and Get the Details of the User
 *     by handling and mapping the request to the appropriate function
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
     *     Create User
     * </h1>
     * <p>
     *     Gets the Input Parameter as a Request from the Client
     *     to Create new User for the Ideas2Movie application
     *     by sending the User DTO
     *     to User Service to perform Business Logic to create
     * </p>
     *
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
     *     Gets the Input parameter as a Request from the Client
     *     to Get the User By ID by sending the ID to User Service
     *     to perform Business Logic to Get
     * </p>
     *
     * @param id - ID of the User to get the User
     * @return ResponseEntity - Holds the User Response DTO and Http Status
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
     *     Gets the Input parameter as a Request from the Client
     *     to Update the User
     *     by Sending the UserDTO to User Service
     *     to perform Business Logic to Update
     * </p>
     *
     * @param id -ID of the User to update the Detilas of the User
     * @param userDTO - holds the Details of the User
     * @return ResponseEntity - Holds the User Response DTO and Http Status
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
     *     Gets the Input Parameter as a request from the Client
     *     to Delete the User
     *     by Sending the ID of the User to User Service
     *     to perform Business Logic to Delete
     * </p>
     *
     * @param id - ID of the User to Delete the User
     * @return ResponseEntity - Holds the User Response DTO and Http Status
     * @throws NotFoundException - throws when user Not Found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) throws NotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }
}
