package com.site.joblisting.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.site.joblisting.entities.User;
import com.site.joblisting.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl_springDataJpa implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void insertUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void updateUser(int id, User user) {
        User tempUser = userRepository.findById(id).get();
        tempUser.setUserName(user.getUserName());
        tempUser.setUserPwd(user.getUserPwd());
        tempUser.setUserEmail(user.getUserEmail());
        tempUser.setUserRole(user.getUserRole());
        System.out.println();
        userRepository.save(tempUser);

    }

}
