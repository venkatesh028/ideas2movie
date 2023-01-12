/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.exception.NotAcceptableException;
import java.util.List;

import com.ideas2it.ideas2movie.model.Role;
import com.ideas2it.ideas2movie.dto.RoleDTO;
import com.ideas2it.ideas2movie.dto.responsedto.RoleResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     RoleService
 * </h1>
 * <p>
 *     RoleService used to Manage the Operations for the Role
 *     Like Creating, Viewing the Details of the Role
 *     and Throws an Exceptions accordingly
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface RoleService {

    /**
     * <h1>
     *     createRole
     * </h1>
     * <p>
     *     Creates the Role for the User
     *     by getting the RoleDTO from the Controller
     * </p>
     *
     * @param roleDTO - Holds the Details of the Role
     * @return RoleResponseDTO - Holds the Details of the Created Role
     * @throws AlreadyExistException - when the Role id Already present
     */
    RoleResponseDTO createRole(RoleDTO roleDTO) throws AlreadyExistException;

    /**
     * <h1>
     *     getAllRole
     * </h1>
     * <p>
     *     Gets all the Role for the User
     * </p>
     *
     * @return List<RoleResponseDTO> - Holds the List of Role
     * @throws NoContentException - when No Role Found
     */
    List<RoleResponseDTO> getAllRoles() throws NoContentException;

    /**
     * <h1>
     *     getRoleById
     * </h1>
     * <p>
     *     Gets the Details of the Role
     *     by getting the ID from the Controller
     * </p>
     * @param id - ID of the Role
     * @return Role - Holds the details of the Role
     * @throws NotFoundException - When Role is Not Found
     */
    Role getRoleById(Long id) throws NotFoundException;
}
