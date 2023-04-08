package com.site.joblisting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @GetMapping("/basicAuth")
    public String basicAuthCheck() {
        return "Authentication Success";
    }

    @PostMapping
    public ResponseEntity<String> authUserByEmailPassword(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok("Authenticated");
    }
}
