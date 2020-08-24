package com.myPosts.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
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
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt = new Date();
}
