package com.site.joblisting.repositories;

import com.site.joblisting.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query
    Optional<Users> findByUserEmail(String userEmail);
}
