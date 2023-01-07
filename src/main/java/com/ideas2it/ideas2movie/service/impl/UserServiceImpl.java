/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.dto.UserDTO;
import com.ideas2it.ideas2movie.dto.responsedto.UserResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.User;
import com.ideas2it.ideas2movie.repository.UserRepository;
import com.ideas2it.ideas2movie.service.RoleService;
import com.ideas2it.ideas2movie.service.UserService;
import com.ideas2it.ideas2movie.util.constant.Message;

/**
 * <h1>
 *     User Service Impl
 * </h1>
 * <p>
 *     Implements the User Service and
 *     Holds the Business Logics
 *     to Create, Update, Get and Delete
 *     the Details of the User
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper mapper = new ModelMapper();

    /**
     * <h1>
     *     User Service Impl Constructor
     * </h1>
     * <p>
     *     Used to Achieve the Autowiring for User Service
     * </p>
     *
     * @param userRepository - reference variable of User repository
     * @param roleService - reference variable of Role Service
     */
    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponseDTO createUser(UserDTO userDTO) throws AlreadyExistException, NotFoundException {
        User user = mapper.map(userDTO, User.class);

        if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            throw new AlreadyExistException(Message.NUMBER_ALREADY_EXIST);
        } else if (userRepository.existsByName(user.getName())) {
            throw new AlreadyExistException(Message.USER_NAME_ALREADY_EXIST);
        } else {
            user.setRole(roleService.getRoleById(userDTO.getRole().getId()));
        }
        return mapper.map(userRepository.save(user), UserResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponseDTO getUserById(Long id) throws NotFoundException {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            throw new NotFoundException(Message.USER_NOT_FOUND);
        }
        return mapper.map(user, UserResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponseDTO updateUser(Long id, UserDTO userDTO) throws NotFoundException, AlreadyExistException {
        User user = mapper.map(userDTO, User.class);
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
                throw new AlreadyExistException(Message.NUMBER_ALREADY_EXIST);
            } else if (userRepository.existsByName(user.getName())) {
                throw new AlreadyExistException(Message.USER_NAME_ALREADY_EXIST);
            } else {
                return mapper.map(userRepository.save(user), UserResponseDTO.class);
            }
        }
        throw new NotFoundException(Message.USER_NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String deleteUser(Long id) throws NotFoundException {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            userRepository.deleteById(id);

            if (userRepository.findById(id).isEmpty()) {
                return Message.DELETED_SUCCESSFULLY;
            }
        }
        throw new NotFoundException(Message.USER_NOT_FOUND);
    }

}
