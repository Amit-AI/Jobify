package com.site.joblisting.repositories;

import com.site.joblisting.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
