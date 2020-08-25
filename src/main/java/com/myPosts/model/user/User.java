package com.myPosts.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//mark class as an Entity
@Entity
//defining class name as Table name
@Table(name = "user")
public class User implements Serializable {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private long id;
//defining id as column name
    @Column(unique = true, name = "user_name", nullable = false)
    private String userName;

    @Column(name="full_name", nullable = false)
    private String fullName;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt = new Date();

}