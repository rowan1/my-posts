package com.myPosts.service;

import com.myPosts.model.Post;
import com.myPosts.model.User;
import com.myPosts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<Post>();
        postRepository.findAll().forEach(post -> posts.add(post));
        return posts;
    }
}
