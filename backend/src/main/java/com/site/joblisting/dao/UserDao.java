package com.site.joblisting.dao;

import com.site.joblisting.entities.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUserById(int id);

    void insertUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);

    List<Integer> getAllJobIdByUserId(int userId);

}
