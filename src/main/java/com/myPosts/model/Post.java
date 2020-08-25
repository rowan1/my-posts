package com.myPosts.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="post")
public class Post implements Serializable {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "status", nullable = false)
    private PostStatus status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt = new Date();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
