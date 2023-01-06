/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import com.ideas2it.ideas2movie.dto.RoleDTO;
import com.ideas2it.ideas2movie.dto.responsedto.RoleResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Role;
import com.ideas2it.ideas2movie.repository.RoleRepository;
import com.ideas2it.ideas2movie.service.RoleService;
import com.ideas2it.ideas2movie.util.constant.Message;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper mapper = new ModelMapper();
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public RoleResponseDTO createRole(RoleDTO roleDTO) throws AlreadyExistException {
        Role role = mapper.map(roleDTO, Role.class);

        if (roleRepository.existsByName(role.getName())) {
            throw new AlreadyExistException(Message.ROLE_NAME_ALREADY_EXIST);
        }
        return mapper.map(roleRepository.save(role), RoleResponseDTO.class);
    }

    @Override
    public Role getRoleById(Long id) throws NotFoundException {
        Optional<Role> role = roleRepository.findById(id);

        if (null == role) {
            throw new NotFoundException(Message.ROLE_NOT_FOUND);
        }
        return role.get();
    }

    @Override
    public List<RoleResponseDTO> getAllRoles() throws NotFoundException {
        List<Role> roles = roleRepository.findAll();
        RoleResponseDTO roleResponseDTO;

        if (roles.isEmpty()) {
            throw new NotFoundException(Message.ROLE_NOT_FOUND);
        }
        List<RoleResponseDTO> roleResponseDTOList = new ArrayList<>();

        for (Role role : roles) {
            roleResponseDTOList.add(mapper.map(role, RoleResponseDTO.class));
        }
        return roleResponseDTOList;
    }
}
