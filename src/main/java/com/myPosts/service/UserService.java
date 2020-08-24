package com.myPosts.service;

import java.util.ArrayList;
import java.util.List;

import com.myPosts.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myPosts.repository.UserRepository;

//defining the business logic
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //getting all student records
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    //getting a specific record
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    //deleting a specific record
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}