package com.myPosts.controller;

import com.myPosts.model.UserPrincipal;
import org.springframework.security.core.Authentication;

public abstract class AbstractController {

    public UserPrincipal getUserDetails(Authentication authentication) {
        return (UserPrincipal) authentication.getPrincipal();
    }

}
