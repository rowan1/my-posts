package com.myPosts.controller;

import java.util.List;

import com.myPosts.model.User;
import com.myPosts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController extends AbstractController{
    @Autowired
    UserService userService;

    @GetMapping("/user")
    private List<User> getAllUsers(Authentication auth) {
        return userService.getAllUsers();
    }

    @GetMapping("/user/info")
    private User getUser(Authentication authentication) {
        User user = getUserDetails(authentication).getUser();
        return user;
    }

    //creating a delete mapping that deletes a specific user
    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }

    //creating post mapping that post the user detail in the database
    @PostMapping("/user")
    private User saveUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user;
    }
}
