package com.myPosts.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.myPosts.model.Post;
import com.myPosts.model.User;
import com.myPosts.repository.PostRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    private EntityManager entityManager;

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<Post>();
        postRepository.findAll().forEach(post -> posts.add(post));
        return posts;
    }
    public Post save(Post body){
        Post post = postRepository.save(body);
        return post;
    }
    public List<Post> searchPosts(String text){
        List<Post> posts = new ArrayList<>();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> postRoot = criteriaQuery.from(Post.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.like(postRoot.get("content"), text));
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        posts = entityManager.createQuery(criteriaQuery).getResultList();
        return posts;
    }
}
