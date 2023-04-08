package com.site.joblisting.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthConfig {

    private static final Logger logger = LoggerFactory.getLogger(BasicAuthConfig.class);

    /**
     * Redefined SecurityFilterChain to override default spring security Configuration for Authenticated & Authorization
     *
     * @param http used to define the security filter chain
     * @return "http builder that defines the security filter chain"
     * @throws  Exception httpException
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        logger.debug("BasicAuthConfig : filterChain : IN");

        http
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .cors().and()
                .csrf().disable();

        logger.debug("BasicAuthConfig : filterChain : OUT");
        return http.build();
    }


    /**
     * //Redefined UserDetailsService to override default spring security Configuration, and storing authorized user details in DB
     *
     * @return returns or saves user details that are authorized to use the application
     */
    // TODO: store user data in actual database, not in-memory
    @Bean
    public UserDetailsService userDetailsService() {
        logger.debug("BasicAuthConfig : userDetailsService : IN");

        UserDetails admin = User.withUsername("amit@admin.com").password("{noop}1234").roles(UserRole.ADMIN.getAuthority()).build();
        UserDetails user = User.withUsername("osama@user.com").password("{noop}1234").roles(UserRole.USER.getAuthority()).build();

        logger.debug("BasicAuthConfig : userDetailsService : OUT");
        return new InMemoryUserDetailsManager(admin, user);
    }
}