package com.site.joblisting.dao;

import com.site.joblisting.dto.UserResponseDTO;
import com.site.joblisting.entities.Jobs;
import com.site.joblisting.entities.Users;

import java.util.List;

public interface UserDao {

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(int id);

    void insertUser(Users user);

    void updateUser(int id, Users user);

    void deleteUser(int id);

    List<Integer> getAllJobIdByUserId(int userId);

    List<Jobs> getAllUserAppliedJobs(int userId);

    Users findByUserEmail(String userEmail);

}
