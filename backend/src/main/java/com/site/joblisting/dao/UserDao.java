package com.site.joblisting.dao;

import com.site.joblisting.dto.UserResponseDTO;
import com.site.joblisting.entities.Job;
import com.site.joblisting.entities.User;

import java.util.List;

public interface UserDao {

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(int id);

    void insertUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);

    List<Integer> getAllJobIdByUserId(int userId);

    List<Job> getAllUserAppliedJobs(int userId);

    User findByUserEmail(String userEmail);

}
