package com.site.joblisting.controller;

import com.site.joblisting.dao.UserDao;
import com.site.joblisting.dto.LoginRequestDTO;
import com.site.joblisting.dto.LoginResponseDTO;
import com.site.joblisting.entities.Users;
import com.site.joblisting.exceptions.NotFoundException;
import com.site.joblisting.security.CustomUserDetailsService;
import com.site.joblisting.security.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }

    @PostMapping("auth/v1/sign-up")
    public ResponseEntity<?> signUp(@RequestBody Users user) {
        try {
            if (user == null || user.getUserName() == null || user.getUserEmail() == null || user.getUserPwd() == null) {
                throw new RuntimeException("Invalid User Credentials");
            }
            userDao.insertUser(user);
        } catch (Exception e) {
            log.debug("Error in Sign up", e);
            return ResponseEntity.badRequest().body("Sign Up failed");
        }

        return ResponseEntity.ok("Sign Up successful");
    }

    @PostMapping("auth/v1/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginDetails) {

        LoginResponseDTO response = new LoginResponseDTO();
        String jwt = null;
        try {
            if (loginDetails == null || loginDetails.getEmail() == null || loginDetails.getPassword() == null) {
                throw new NotFoundException("Invalid User Credentials");
            }
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDetails.getEmail(), loginDetails.getPassword()));

            log.debug("Authentication success for user: {}", loginDetails.getEmail());

            UserDetails userDetails = userDetailsService.loadUserByUsername(loginDetails.getEmail());

            jwt = jwtUtils.generateToken(userDetails.getUsername());


        } catch (AuthenticationException e) {
            log.debug("Error occurred during login..", e);
            return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
        }

        response.setToken(jwt);

        return ResponseEntity.ok(response);
    }
}
