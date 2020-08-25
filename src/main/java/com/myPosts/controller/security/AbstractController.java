package com.myPosts.controller.security;

import com.myPosts.model.user.UserPrincipal;
import org.springframework.security.core.Authentication;

public abstract class AbstractController {

    public UserPrincipal getUserDetails(Authentication authentication) {
        return (UserPrincipal) authentication.getPrincipal();
    }

}
