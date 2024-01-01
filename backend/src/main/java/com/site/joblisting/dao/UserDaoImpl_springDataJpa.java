package com.site.joblisting.dao;

import com.site.joblisting.entities.Job;
import com.site.joblisting.entities.User;
import com.site.joblisting.exceptions.NotFoundException;
import com.site.joblisting.exceptions.UserAlreadyExistsException;
import com.site.joblisting.repositories.UserJobRepository;
import com.site.joblisting.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Transactional
public class UserDaoImpl_springDataJpa implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserJobRepository userJobRepository;

    @Autowired
    JobDao jobDao;


    @Override
    public List<User> getAllUsers() {
        log.debug("UserDaoImpl_springDataJpa: : getAllUsers: IN");

        List<User> users = userRepository.findAll();

        log.debug("UserDaoImpl_springDataJpa: : getAllUsers: OUT");
        return users;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User Not Found With ID: " + id));
    }

    @Override
    public User findByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new NotFoundException("User Not Found with email: " + userEmail));
    }

    @Override
    public void insertUser(User user) {
        Optional<User> userDetails = userRepository.findByUserEmail(user.getUserEmail());

        if (userDetails.isPresent()) {
            throw new UserAlreadyExistsException("User Already Exists!");
        } else {
            userRepository.save(user);
        }

        log.debug("User details insert for User with Email: {}", user.getUserEmail());

    }

    @Override
    public void updateUser(int id, User user) {
        User tempUser = getUserById(id);

        tempUser.setUserName(user.getUserName());
        tempUser.setUserPwd(user.getUserPwd());
        tempUser.setUserEmail(user.getUserEmail());
        tempUser.setUserRole(user.getUserRole());
        userRepository.save(tempUser);

        log.debug("User details updated for User with ID: {}", id);

    }

    @Override
    public void deleteUser(int id) {
        userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));

        //cleaning up jobs which this user applied to
        userJobRepository.deleteJobWhenUserDeleted(id);

        userRepository.deleteById(id);
    }

    @Override
    public List<Integer> getAllJobIdByUserId(int userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));

        return userJobRepository.findAllJobIdByUserId(userId);
    }

    @Override
    public List<Job> getAllUserAppliedJobs(int userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));

        List<Integer> jobIDs = getAllJobIdByUserId(userId);

        return jobIDs.stream()
                .map(id -> jobDao.getJob(id))
                .toList();
    }

}
