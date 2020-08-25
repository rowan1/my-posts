package com.myPosts.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.myPosts.model.Post;
import com.myPosts.model.User;
import com.myPosts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController extends AbstractController {
    @Autowired
    PostService service;
    @GetMapping("/post")
    private List<Post> getAllPosts() {
        return service.getAllPosts();
    }

    @GetMapping("/post/search")
    private ResponseEntity<List<Post>> getPostByText(@RequestParam String text){
//        User user = getUserDetails(authentication).getUser();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.searchPosts(text));
    }
    @PostMapping("post")
    private ResponseEntity save(@RequestBody Post post, Authentication authentication){
        User user = getUserDetails(authentication).getUser();
        Post savedPost = service.save(post, user.getId());
        return savedPost != null? ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedPost): (ResponseEntity) ResponseEntity
                .status(HttpStatus.BAD_REQUEST);
    }
}
