/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.ideas2movie.dto.RoleDTO;
import com.ideas2it.ideas2movie.dto.responsedto.RoleResponseDTO;
import com.ideas2it.ideas2movie.service.RoleService;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NoContentException;

/**
 * <h1>
 *     RoleController
 * </h1>
 * <p>
 *     Gets the Input Parameter as a request from the Client and Validates them
 *     for Creating and Getting the Details of the Role
 *     and used to handle and Mapping the request to appropriate function
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    private final RoleService roleService;

    /**
     * <h1>
     *     RoleController Constructor
     * </h1>
     * <p>
     *     Used to initialize the Services for calling the Operation performers of Service
     *     and also achieves the Autowiring
     * </p>
     *
     * @param roleService - An instance of a RoleService
     */
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * <h1>
     *     createRole
     * </h1>
     * <p>
     *     Gets the RequestBody for creating the Role and validates according to Validation Constraints
     *     and process the request by sending to RoleService and returns the RoleResponseDTO and Http Status
     *     or throws an exception when occurred
     * </p>
     *
     * @param roleDTO - role details to create a new role
     * @return ResponseEntity - Holds the Role response DTO and Http Status
     */
    @PostMapping
    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody RoleDTO roleDTO) throws AlreadyExistException {
        return ResponseEntity.status(HttpStatus.OK).body(roleService.createRole(roleDTO));
    }

    /**
     * <h1>
     *     getAllRole
     * </h1>
     * <p>
     *     Gets the Call to Get all the Roles for the User
     *     and process the request by sending to RoleService and returns the RoleResponseDTO and Http status
     *     or throws an Exception when occurred
     * </p>
     *
     * @return ResponseEntity - Holds the Role response DTO and Http Status
     * @throws NoContentException - when no Role Found
     */
    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() throws NoContentException {
        return ResponseEntity.status(HttpStatus.OK).body(roleService.getAllRoles());
    }
}
