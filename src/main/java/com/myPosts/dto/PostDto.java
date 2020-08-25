package com.myPosts.dto;

import com.myPosts.model.post.Post;
import com.myPosts.model.post.PostStatus;
import java.util.Date;

public class PostDto {
    String content;
    PostStatus status;
    Date createdAt;
    String userName;

    public PostDto mapPostToPostDto(Post post){
        this.content = post.getContent();
        this.status = post.getStatus();
        this.userName = post.getUser().getUserName();
        this.createdAt = post.getCreatedAt();
        return this;
    }
}
