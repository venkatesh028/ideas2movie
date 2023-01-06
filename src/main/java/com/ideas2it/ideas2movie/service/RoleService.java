/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.RoleDTO;
import com.ideas2it.ideas2movie.dto.responsedto.RoleResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;

import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Role;
import java.util.List;

/**
 * <h1>
 *     Role Service Interface
 * </h1>
 * <p>
 *     Service Layer for the Role
 *     to Create, and Get the Role
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface RoleService {
    RoleResponseDTO createRole(RoleDTO roleDTO) throws AlreadyExistException;
    List<RoleResponseDTO> getAllRoles() throws NotFoundException;
    Role getRoleById(Long id) throws NotFoundException;
}
