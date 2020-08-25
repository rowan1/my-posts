package com.myPosts.service;

import com.myPosts.model.post.Post;
import com.myPosts.model.post.PostStatus;
import com.myPosts.model.user.User;
import com.myPosts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
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
    public Post save(Post body, User user){
        body.setUser(user);
        Post post = postRepository.save(body);
        return post;
    }
    public List<Post> searchPosts( User user, String text){
        String[] words = text.split(" ");
        List<Post> posts = new ArrayList<>();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> postRoot = criteriaQuery.from(Post.class);
        EntityType<Post> post = entityManager.getMetamodel().entity(Post.class);
        List<Predicate> predicates = new ArrayList<>();
        for(String word: words){
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(
                    postRoot.get(
                            post.getDeclaredSingularAttribute("content", String.class)
                    )
                    ), "%" + word.toLowerCase() + "%"));

//                    postRoot.get("content"), "%"+word+"%"));
        }
        predicates.add(criteriaBuilder.equal(postRoot.get("status"), PostStatus.PUBLIC));
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        posts = entityManager.createQuery(criteriaQuery).getResultList();

        return posts;
    }
    public List<Post> getUserPosts(User user){
        List<Post> posts = postRepository.getUserPosts(user.getId());
        return posts;
    }
}
