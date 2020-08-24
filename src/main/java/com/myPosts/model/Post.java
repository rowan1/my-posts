package com.myPosts.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="post")
public class Post {
    @Id

    @Column
    private String content;
    @Column
    private PostStatus status;
    @Column
    private String authorId;
    @CreatedDate
    private Date createdAt;
}
