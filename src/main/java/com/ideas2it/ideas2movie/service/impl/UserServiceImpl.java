/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.User;
import com.ideas2it.ideas2movie.dto.UserDTO;
import com.ideas2it.ideas2movie.dto.responsedto.UserResponseDTO;
import com.ideas2it.ideas2movie.service.RoleService;
import com.ideas2it.ideas2movie.service.UserService;
import com.ideas2it.ideas2movie.repository.UserRepository;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     UserServiceImpl
 * </h1>
 * <p>
 *     UserServiceImpl provides Business logic for the CRUD to handling the User Account
 *     and by interacting with the Repository to store and fetches the Details of the User
 *     bCrypt technique is used to Encrypt the Password of the User
 *     and throws custom Exceptions accordingly when occurred
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
     *     UserServiceImpl Constructor
     * </h1>
     * <p>
     *     Used to  inject the UserRepository, RoleService dependency
     *     and initialize the userRepository, roleService variables
     * </p>
     *
     * @param userRepository - Instance of the UserRepository
     * @param roleService - Instance of the RoleService
     */
    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponseDTO createUser(UserDTO userDTO) throws AlreadyExistException, BadRequestException {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user = mapper.map(userDTO, User.class);
        user.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));

        if (userRepository.existsByPhoneNumber(user.getPhoneNumber())
                && userRepository.existsByName(user.getName())) {
            throw new AlreadyExistException(Message.NAME_AND_NUMBER_ALREADY_EXIST);
        } else if (userRepository.existsByName(user.getName())) {
            throw new AlreadyExistException(Message.USER_NAME_ALREADY_EXIST);
        } else if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            throw new AlreadyExistException(Message.NUMBER_ALREADY_EXIST);
        } else {
            try {
                user.setRole(roleService.getRoleById(userDTO.getRoleId()));
            } catch (NotFoundException notFoundException) {
                throw new BadRequestException(notFoundException.getMessage());
            }
        }
        return mapper.map(userRepository.save(user), UserResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponseDTO getUserById(Long id) throws NotFoundException {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new NotFoundException(Message.USER_NOT_FOUND);
        }
        return mapper.map(user.get(), UserResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponseDTO updateUser(Long id, UserDTO userDTO) throws NotFoundException {
        User user = mapper.map(userDTO, User.class);
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Message.USER_NOT_FOUND);
        }
        existingUser.get().setId(id);
        existingUser.get().setName(user.getName());
        existingUser.get().setEmail(user.getEmail());
        existingUser.get().setPhoneNumber(user.getPhoneNumber());
        existingUser.get().setRole(roleService.getRoleById(userDTO.getRoleId()));
        return mapper.map(userRepository.save(existingUser.get()), UserResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteUser(Long id) throws NotFoundException {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Message.USER_NOT_FOUND);
        }
        User user = existingUser.get();
        user.setActive(false);
        return userRepository.save(user).isActive();
    }
}
