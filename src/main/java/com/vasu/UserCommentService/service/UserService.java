package com.vasu.UserCommentService.service;

import com.vasu.UserCommentService.model.CommentRequest;
import com.vasu.UserCommentService.model.CommentResponse;
import com.vasu.UserCommentService.model.UserRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<String> addNewComment(UserRequest userRequest);

    ResponseEntity<List<CommentResponse>> getAllComments(CommentRequest commentRequest);
}
