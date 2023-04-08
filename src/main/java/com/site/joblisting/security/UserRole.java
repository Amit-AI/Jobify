package com.site.joblisting.security;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {

    USER,
    RECRUITER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
