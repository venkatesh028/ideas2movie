/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import jakarta.validation.Valid;

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
 *     RoleController provides the RESTful Endpoints to handle CRUD operations
 *     for the Role of the User and Validates the Information of the RoleDTO
 *     according to Validation Constraints and throws an Exception when occurred
 *     and returns the Details of Role and Http Status
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
     *     Creates the Role for the User of the Application by validates the RoleDTO
     *     according to Validation Constraints If not valid throws an Exception
     *     else process the request and returns the ResponseEntity with Http Status CREATED
     *     and Details of the Role
     * </p>
     *
     * @param roleDTO - Holds the role details to create a new role
     * @return ResponseEntity - Holds the RoleResponseDTO and Http Status CREATED
     * @throws AlreadyExistException - when Role is Already Created for user
     */
    @PostMapping
    public ResponseEntity<RoleResponseDTO> createRole(@Valid @RequestBody RoleDTO roleDTO)
            throws AlreadyExistException {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.createRole(roleDTO));
    }

    /**
     * <h1>
     *     getAllRoles
     * </h1>
     * <p>
     *     Retrieves the List of All Role and process the request If No Role Found for the User then
     *     throws an Exception otherwise returns the ResponseEntity with Http Status OK and List of Roles
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
