package com.site.joblisting.controller;

import com.site.joblisting.dao.JobDao;
import com.site.joblisting.dao.UserDao;
import com.site.joblisting.dto.UserJobDTO;
import com.site.joblisting.dto.UserResponseDTO;
import com.site.joblisting.entities.Job;
import com.site.joblisting.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JobDao jobDao;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        logger.debug("UserController: getAllUsers : IN");

        List<UserResponseDTO> users = userDao.getAllUsers();

        logger.debug("UserController: getAllUsers : OUT");
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable int id) {
        logger.debug("UserController: getUser : IN");

        UserResponseDTO user = userDao.getUserById(id);

        logger.debug("UserController: getUser : OUT");
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<String> insertUser(@Validated @RequestBody User user) {
        logger.debug("UserController: insertUser : IN");

        userDao.insertUser(user);

        logger.debug("UserController: insertUser : OUT");
        return new ResponseEntity<>("User inserted successfully!!", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
        logger.debug("UserController: updateUser : IN");

        userDao.updateUser(id, user);

        logger.debug("UserController: updateUser : OUT");
        return ResponseEntity.ok("User updated successfully!!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        logger.debug("UserController: deleteUser : IN");

        userDao.deleteUser(id);

        logger.debug("UserController: deleteUser : OUT");
        return ResponseEntity.ok("User deleted successfully!!");
    }

    @GetMapping("/jobs/{userId}")
    public ResponseEntity<UserJobDTO> getUserAppliedJobs(@PathVariable int userId) {
        logger.debug("UserController: getUserAppliedJobs : IN");

        UserResponseDTO user = userDao.getUserById(userId);
        String email = user.getEmail();
        List<Job> jobs = userDao.getAllUserAppliedJobs(userId);

        logger.debug("UserController: getUserAppliedJobs : OUT");
        return ResponseEntity.ok(new UserJobDTO(email, jobs));
    }

}
