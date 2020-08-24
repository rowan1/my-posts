package com.myPosts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//mark class as an Entity
@Entity
//defining class name as Table name
@Table(name = "user")
public class User implements Serializable {
    @Id
//defining id as column name
    @Column
    private int id;
    @Column(unique = true)
    private String userName;
    @Column
    private String fullName;
    @JsonIgnore
    private String password;
    @CreatedDate
    private Date createdAt;

    @OneToMany(targetEntity = Post.class)
    private List<Post> posts;
}