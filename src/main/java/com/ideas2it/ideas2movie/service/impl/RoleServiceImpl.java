/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Role;
import com.ideas2it.ideas2movie.dto.RoleDTO;
import com.ideas2it.ideas2movie.dto.responsedto.RoleResponseDTO;
import com.ideas2it.ideas2movie.service.RoleService;
import com.ideas2it.ideas2movie.repository.RoleRepository;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.logger.CustomLogger;

/**
 * <h2>
 *     RoleServiceImpl
 * </h2>
 * <p>
 *     RoleServiceImpl provides the Business logic to perform CRUD like
 *     Creating Role for User, Fetches the Details of the All Role, and By ID
 *     and Throws appropriate Exception when needed and Also Logs the Error for debugging
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final CustomLogger logger = new CustomLogger(RoleServiceImpl.class);
    private final ModelMapper mapper = new ModelMapper();

    /**
     * <h1>
     *     RoleServiceImpl Constructor
     * </h1>
     * <p>
     *      inject the RoleRepository dependency and initialize the roleRepository variable
     * </p>
     *
     * @param roleRepository - Instance of the RoleRepository
     */
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleResponseDTO createRole(RoleDTO roleDTO) throws AlreadyExistException {
        logger.info("Inside the RoleServiceImpl create Role");
        Role role = mapper.map(roleDTO, Role.class);

        if (roleRepository.existsByName(role.getName())) {
            logger.error(Message.ROLE_NAME_ALREADY_EXIST);
            throw new AlreadyExistException(Message.ROLE_NAME_ALREADY_EXIST);
        }
        return mapper.map(roleRepository.save(role), RoleResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role getRoleById(Long id) throws NotFoundException {
        logger.info("Inside the RoleServiceImpl get Role By ID");
        Optional<Role> role = roleRepository.findById(id);

        if (role.isEmpty()) {
            logger.error(Message.ROLE_NOT_FOUND);
            throw new NotFoundException(Message.ROLE_NOT_FOUND);
        }
        return role.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RoleResponseDTO> getAllRoles() throws NoContentException {
        logger.info("Inside the RoleServiceImpl get All Roles");
        List<Role> roles = roleRepository.findAll();

        if (roles.isEmpty()) {
            logger.error(Message.ROLE_NOT_FOUND);
            throw new NoContentException(Message.ROLE_NOT_FOUND);
        }
        List<RoleResponseDTO> roleResponseDTOList = new ArrayList<>();

        for (Role role : roles) {
            roleResponseDTOList.add(mapper.map(role, RoleResponseDTO.class));
        }
        return roleResponseDTOList;
    }
}
