package com.myPosts.repository;

import com.myPosts.model.post.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Query(
            value =
                    "select * from post where user_id = :userId",
            nativeQuery = true)
    List<Post> getUserPosts(@Param("userId") long userId);

}
