package com.myPosts.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.myPosts.model.Post;
import com.myPosts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService service;
    @GetMapping("/post")
    private List<Post> getAllPosts() {
        return service.getAllPosts();
    }

    @GetMapping("/post/search")
    private ResponseEntity<List<Post>> getPostByText(@RequestParam String text){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.searchPosts( text));
    }
    @PostMapping("post")
    private ResponseEntity<Post> save(@RequestBody Post body){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save( body));
    }
}
