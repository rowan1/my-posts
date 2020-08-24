package com.myPosts.controller;

import com.myPosts.model.Post;
import com.myPosts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService service;
    @GetMapping("/post")
    private List<Post> getAllPosts() {
        return service.getAllPosts();
    }
}
