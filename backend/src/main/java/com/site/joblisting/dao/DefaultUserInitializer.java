package com.site.joblisting.dao;

import com.site.joblisting.entities.Users;
import com.site.joblisting.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Slf4j
public class DefaultUserInitializer {

    @Bean
    public CommandLineRunner initializeDefaultUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            log.info("Initializing Default ADMIN user..");
            if(userRepository.count()==0) {
                Users defaultUser = new Users();
                defaultUser.setUserName("Amit");
                defaultUser.setUserPwd(passwordEncoder.encode("1234"));
                defaultUser.setUserEmail("amit@admin.com");
                defaultUser.setUserRole("ADMIN");
                userRepository.save(defaultUser);
            }
        };
    }
}
