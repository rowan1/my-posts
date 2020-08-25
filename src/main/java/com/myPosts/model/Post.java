package com.myPosts.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
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
    @Column
    private String content;
    @Column
    private PostStatus status;
    @Column
    private long authorId;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt = new Date();
}
