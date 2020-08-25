package com.myPosts.controller;

import com.myPosts.model.Post;
import com.myPosts.model.User;
import com.myPosts.service.PostService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController extends AbstractController {
    @Autowired
    PostService service;
    @GetMapping("/post")
    private List<Post> getAllPosts() {
        return service.getAllPosts();
    }

    @GetMapping("post/user")
    private ResponseEntity<List<Post>> getUserPosts(Authentication authentication){
        User user = getUserDetails(authentication).getUser();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getUserPosts(user));
    }
    @GetMapping("/post/search")
    private ResponseEntity<List<Post>> getPostByText(@RequestParam String text, Authentication authentication){
        User user = getUserDetails(authentication).getUser();
        return validateSearchText(text) ? ResponseEntity
                .status(HttpStatus.OK)
                .body(service.searchPosts(user, text)):
                ResponseEntity
                        .status(HttpStatus.NOT_ACCEPTABLE).build();
    }
    @PostMapping("post")
    private ResponseEntity save(@RequestBody Post post, Authentication authentication) throws JSONException {
        User user = getUserDetails(authentication).getUser();
        JSONObject object = checkValidation(post);
        if(!object.getBoolean("check")){
            Post savedPost = service.save(post, user);
            return savedPost != null? ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedPost): (ResponseEntity) ResponseEntity
                    .status(HttpStatus.BAD_REQUEST);
        }else{
         return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(object.getString("message"));
        }
    }

    public boolean validateSearchText(String text){
        return
                (text==null || "".equals(text) || text.isEmpty() || text.split(" ").length == 0 ) ?
                        false: true;
    }
    public JSONObject checkValidation(Post post) throws JSONException {
        JSONObject object = new JSONObject();
        Boolean check = false;
        String message = "";
        if (post.getContent() == null) {
            message = "Post content is mandatory";
            check = true;
        }
        if(post.getStatus() == null){
            check = true;
            message = "Post status is mandatory";
        }
        object.put("check",check);
        object.put("message",message);
        return object;
    }
}
