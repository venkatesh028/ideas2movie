/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ideas2it.ideas2movie.service.SecurityService;

/**
 * <h1>
 *     SecurityConfiguration
 * </h1>
 * <p>
 *     SecurityConfiguration is responsible for configuring Spring Security for the application.
 *     It sets up authentication and authorization rules, and also configures how user details are loaded.
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 17/01/2023
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final SecurityService securityService;

    public SecurityConfiguration(SecurityService securityService){
        this.securityService = securityService;
    }

    /**
     * <h1>
     *     passwordEncoder
     * </h1>
     * <p>
     *     Gives an instance of BCryptPasswordEncoder which is a
     *     widely used and secure implementation of the PasswordEncoder interface.
     *     password encoder is used to securely encode and compare passwords      *
     * </p>
     *
     * @return BcryptPasswordEncoder - A fully configured PasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * <h1>
     *     configure
     * </h1>
     * <p>
     *      Configures the security for the application by setting up rules for different HTTP requests.
     *      It takes in an HttpSecurity object as a parameter, which is used to configure the security
     *      for the application. Uses the authorizeHttpRequests method to set up rules for different HTTP requests.
     *      These rules are defined using request matchers, which match the request based on the HTTP method
     *      and the URL path.
     * </p>
     * @param httpSecurity - Provides a fluent API for configuring security for a web application
     * @return SecurityFilterChain - A fully configured SecurityFilterChain object
     * @throws Exception - Occurs when authentication is invalid.
     */
    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity)
            throws Exception {
        httpSecurity.authenticationProvider(daoAuthenticationProvider());

        return httpSecurity.csrf().disable()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/api/v1/roles")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/users")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST, "api/v1/theaters")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.PUT, "api/v1/theaters")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.DELETE, "api/v1/theaters")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.POST, "api/v1/movies")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.PUT, "api/v1/movies")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.DELETE, "api/v1/movies")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.POST, "api/v1/screens")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.PUT, "api/v1/screens")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.DELETE, "api/v1/screens")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.POST, "api/v1/shows")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.PUT, "api/v1/shows")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.DELETE, "api/v1/shows")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.POST, "api/v1/movies")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.PUT, "api/v1/movies")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.DELETE, "api/v1/movies")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.POST, "api/v1/reservations")
                        .hasAnyAuthority("admin", "customer")
                        .requestMatchers(HttpMethod.DELETE, "api/v1/reservations")
                        .hasAnyAuthority("admin","customer")
                        .requestMatchers(HttpMethod.GET, "api/v1/movies")
                        .hasAnyAuthority("admin","customer")
                        .requestMatchers(HttpMethod.GET,"api/v1/shows/of-movie/{movieName}")
                        .hasAnyAuthority("admin","customer")
                        .requestMatchers(HttpMethod.GET, "api/v1/shows/{id}")
                        .hasAnyAuthority("admin", "customer")
                        .requestMatchers(HttpMethod.GET, "api/v1/shows/of-screen/{id}")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.GET, "api/v1/screens/{id}")
                        .hasAuthority("admin")
                        .requestMatchers(HttpMethod.GET, "api/v1/reservations/of-user/{id}")
                        .hasAnyAuthority("admin", "customer")
                        .requestMatchers(HttpMethod.GET, "api/v1/reservations/{id}")
                        .hasAnyAuthority("admin","customer")
                        .requestMatchers(HttpMethod.GET, "api/v1/payments/by-transaction/{id}")
                        .hasAnyAuthority("admin", "customer")
                        .requestMatchers(HttpMethod.GET, "api/v1/payments/{id}")
                        .hasAnyAuthority("admin", "customer")
                        .requestMatchers(HttpMethod.POST, "api/v1/payments")
                        .hasAnyAuthority("admin", "customer")
                        .requestMatchers(HttpMethod.GET, "api/v1/tickets")
                        .hasAnyAuthority("admin", "customer")
                )
                .authorizeHttpRequests().anyRequest().authenticated().and()
                        .httpBasic().and().build();
    }

    /**
     * <h1>
     *     authenticationManagerBean
     * </h1>
     * <p>
     *     Takes in an AuthenticationConfiguration object as a parameter
     *     And retrieves the AuthenticationManager from it.
     *     It throws an Exception if there is a problem creating the AuthenticationManager.
     *
     * </p>
     * @param authenticationConfiguration - Holds the Configuration details of the authenticationConfiguration
     * @return authenticationManager - Holds the details of the authenticationManager
     * @throws Exception - Occurs when any issue in getting the AuthenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * <h1>
     *     daoAuthenticationProvider
     * </h1>
     * <p>
     *     Provide the authentication provider to verify the credentials of user.
     * </p>
     * @return configured authentication provider
     */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(securityService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
}
