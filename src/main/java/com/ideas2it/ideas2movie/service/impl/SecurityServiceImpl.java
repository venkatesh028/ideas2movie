package com.ideas2it.ideas2movie.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.User;
import com.ideas2it.ideas2movie.repository.UserRepository;
import com.ideas2it.ideas2movie.security.SecurityUserDetails;
import com.ideas2it.ideas2movie.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

    private final UserRepository userRepository;

    public SecurityServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByPhoneNumber(username);

        if (null == user) {
            throw new UsernameNotFoundException("There No user with is number");
        }
        return new SecurityUserDetails(user);
    }
}
