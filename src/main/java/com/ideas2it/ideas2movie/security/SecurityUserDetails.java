/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ideas2it.ideas2movie.model.User;

/**
 * SecurityUserDetails is responsible for holding user details
 * And It holds information such as username, password,
 * And granted authorities for a user.
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 17/01/2023
 */
public class SecurityUserDetails implements UserDetails {
    private boolean isActive;
    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;

    public SecurityUserDetails(User user) {
        userName = user.getPhoneNumber();
        password = user.getPassword();
        isActive = user.isActive();
        authorities = Arrays
                .asList(new SimpleGrantedAuthority((user.getRole().getName())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
