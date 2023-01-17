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

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final SecurityService securityService;

    public SecurityConfig(SecurityService securityService){
        this.securityService = securityService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

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
     *
     * </h1>
     * <p>
     *
     * </p>
     * @param authenticationConfiguration
     * @return
     * @throws Exception
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
