package com.site.joblisting.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class BasicAuthConfig {

    private static final Logger logger = LoggerFactory.getLogger(BasicAuthConfig.class);

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Redefined SecurityFilterChain to override default spring security Configuration for Authenticated & Authorization
     *
     * @param http used to define the security filter chain
     * @return "http builder that defines the security filter chain"
     * @throws Exception httpException
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        logger.debug("BasicAuthConfig : filterChain : IN");

        http
                .csrf(AbstractHttpConfigurer::disable)
//                .cors(Customizer.withDefaults()) //for allowing any origin's request
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowedOrigins(List.of("http://localhost:5173")); //origin for the vite+react frontend application
                    corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                    corsConfiguration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
                    return corsConfiguration;
                }))
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults());

        logger.debug("BasicAuthConfig : filterChain : OUT");
        return http.build();
    }


    /**
     * //Redefined UserDetailsService to override default spring security Configuration, and storing authorized user details in DB
     *
     * @return returns or saves user details that are authorized to use the application
     */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserDetailsService userDetailsService) {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }


   /* Commented below because, updated the UserDetailsService to fetch User from DataBase

   @Bean
    public UserDetailsService userDetailsService() {
        logger.debug("BasicAuthConfig : userDetailsService : IN");

        UserDetails admin = User.withUsername("amit@admin.com").password("{noop}1234").roles(UserRole.ADMIN.getAuthority()).build();
        UserDetails user = User.withUsername("osama@user.com").password("{noop}1234").roles(UserRole.USER.getAuthority()).build();

        logger.debug("BasicAuthConfig : userDetailsService : OUT");
        return new InMemoryUserDetailsManager(admin, user);
    }*/
}
