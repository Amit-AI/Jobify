package com.site.joblisting.repositories;

import com.site.joblisting.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query
    Optional<User> findByUserEmail(String userEmail);
}
