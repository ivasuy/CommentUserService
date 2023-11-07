package com.vasu.UserCommentService.controller;

import com.vasu.UserCommentService.model.CommentRequest;
import com.vasu.UserCommentService.model.CommentResponse;
import com.vasu.UserCommentService.model.UserRequest;
import com.vasu.UserCommentService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-comment")
    public ResponseEntity<String> createNewUser(@RequestBody UserRequest userRequest){
        return userService.addNewComment(userRequest);
    }

    @GetMapping("/get-comment")
    public ResponseEntity<List<CommentResponse>> getAllComments(@RequestBody CommentRequest commentRequest){
        return userService.getAllComments(commentRequest);
    }

}
