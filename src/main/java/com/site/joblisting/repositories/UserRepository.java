package com.site.joblisting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.joblisting.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
