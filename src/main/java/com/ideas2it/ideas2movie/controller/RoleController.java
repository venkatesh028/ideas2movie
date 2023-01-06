/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import com.ideas2it.ideas2movie.dto.RoleDTO;
import com.ideas2it.ideas2movie.dto.responsedto.RoleResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.service.RoleService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>
 *     Role Controller
 * </h1>
 * <p>
 *     Gets the Input Parameter as a request
 *     from the Client to Get the Role
 *     by sending the parameter to perform business logic
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@RestController
@RequestMapping("api/v1/role")
public class RoleController {
    private final RoleService roleService;

    /**
     * <h1>
     *     Role Controller Constructor
     * </h1>
     * <p>
     *     Used to achieve the Autowiring for Role Service
     * </p>
     *
     * @param roleService - reference variable of Role Service
     */
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * <h1>
     *     Create Role
     * </h1>
     * <p>
     *     Used to create the Role of the Ideas2Movie User
     *     by getting the Role DTO from the Client
     *     and sends it to the Role service to
     *     perform business logic
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
     *     Get All Role
     * </h1>
     * <p>
     *     Used to get all the Roles of the Ideas2Movie
     *     by calling the Role Service
     * </p>
     *
     * @return ResponseEntity - Holds the Role response DTO and Http Status
     * @throws NotFoundException
     */
    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(roleService.getAllRoles());
    }
}
