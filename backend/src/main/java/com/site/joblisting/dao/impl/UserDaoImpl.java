package com.site.joblisting.dao.impl;

import com.site.joblisting.dao.JobDao;
import com.site.joblisting.dao.UserDao;
import com.site.joblisting.dto.UserResponseDTO;
import com.site.joblisting.entities.Jobs;
import com.site.joblisting.entities.Users;
import com.site.joblisting.exceptions.NotFoundException;
import com.site.joblisting.exceptions.UserAlreadyExistsException;
import com.site.joblisting.repositories.UserJobRepository;
import com.site.joblisting.repositories.UserRepository;
import com.site.joblisting.security.UserRole;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserJobRepository userJobRepository;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<UserResponseDTO> getAllUsers() {
        log.debug("UserDaoImpl_springDataJpa: : getAllUsers: IN");

        List<Users> users = userRepository.findAll();

        List<UserResponseDTO> userDTOs = users.stream().map(user ->
            UserResponseDTO.builder()
                    .id(user.getUserId())
                    .name(user.getUserName())
                    .email(user.getUserEmail())
                    .role(user.getUserRole())
                    .build()
        ).toList();

        log.debug("UserDaoImpl_springDataJpa: : getAllUsers: OUT");
        return userDTOs;
    }

    @Override
    public UserResponseDTO getUserById(int id) {
        Users userDb = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User Not Found With ID: " + id));

        return UserResponseDTO.builder()
                .id(userDb.getUserId())
                .name(userDb.getUserName())
                .email(userDb.getUserEmail())
                .role(userDb.getUserRole())
                .build();
    }

    @Override
    public Users findByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new NotFoundException("User Not Found with email: " + userEmail));
    }

    @Override
    public void insertUser(Users user) {
        Optional<Users> userDetails = userRepository.findByUserEmail(user.getUserEmail());

        if (userDetails.isPresent()) {
            throw new UserAlreadyExistsException("User Already Exists!");
        } else {
            user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));
            if(user.getUserRole()==null) {
                user.setUserRole(UserRole.USER.getAuthority());
            }
            userRepository.save(user);
        }

        log.debug("User details insert for User with Email: {}", user.getUserEmail());

    }

    @Override
    public void updateUser(int id, Users user) {
        Users tempUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found!"));

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
    public List<Jobs> getAllUserAppliedJobs(int userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));

        List<Integer> jobIDs = getAllJobIdByUserId(userId);

        return jobIDs.stream()
                .map(id -> jobDao.getJob(id))
                .toList();
    }

}
