package com.site.joblisting.dao;

import java.util.List;

import com.site.joblisting.entities.User;

public interface UserDao {

    public List<User> getAllUsers();
    public User getUserById(int id);
    public void insertUser(User user);
    public void updateUser(int id, User user);
    public void deleteUser(int id);
    public List<Integer> getAllJobIdByUserId(int userId);
    
}
