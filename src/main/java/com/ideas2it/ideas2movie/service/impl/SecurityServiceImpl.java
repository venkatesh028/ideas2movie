/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.User;
import com.ideas2it.ideas2movie.service.SecurityService;
import com.ideas2it.ideas2movie.repository.UserRepository;
import com.ideas2it.ideas2movie.security.SecurityUserDetails;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.logger.CustomLogger;

/**
 * <h2>
 *     SecurityServiceImpl
 * </h2>
 * <p>
 *     SecurityServiceImpl provides the logic to verify
 *     the user existence by interacting with the user repository
 *     if the user is exist then User details is provided else
 *     exception is thrown
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 17/01/202
 */
@Service
public class SecurityServiceImpl implements SecurityService {
    private final CustomLogger logger = new CustomLogger(SecurityServiceImpl.class);
    private final UserRepository userRepository;

    public SecurityServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByPhoneNumber(username);

        if (null == user) {
            logger.error(Message.ACCOUNT_NOT_FOUND);
            throw new UsernameNotFoundException(Message.ACCOUNT_NOT_FOUND);
        }
        return new SecurityUserDetails(user);
    }
}
