package com.vasu.UserCommentService.service;

import com.vasu.UserCommentService.entity.Comment;
import com.vasu.UserCommentService.entity.User;
import com.vasu.UserCommentService.model.CommentRequest;
import com.vasu.UserCommentService.model.CommentResponse;
import com.vasu.UserCommentService.model.UserRequest;
import com.vasu.UserCommentService.repository.CommentRepository;
import com.vasu.UserCommentService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    public boolean validateUserRequest(UserRequest request) {
        if (isNameValid(request.getCommentFrom()) && isNameValid(request.getCommentTo())) return true;
        else return false;
    }
    private boolean isNameValid(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        String regex = "^[a-zA-Z]*$";
        return Pattern.matches(regex, name);
    }

    @Transactional
    @Override
    public ResponseEntity<String> addNewComment(UserRequest userRequest) {

        if (!validateUserRequest(userRequest)) return new ResponseEntity<>("Invalid Request", HttpStatus.BAD_REQUEST);

        User toUser = userRepository.findCommonNameInCommentsFromTo(userRequest.getCommentTo());

        if(toUser == null){
            User user = User.builder()
                    .commentFrom(userRequest.getCommentFrom())
                    .commentTo(userRequest.getCommentTo())
                    .build();
            userRepository.save(user);

            Comment comment = Comment.builder()
                    .message(userRequest.getMessage())
                    .commentDateTime(LocalDateTime.now())
                    .postedByUserId(user.getUserId())
                    .postedForUserName(userRequest.getCommentTo())
                    .postedByUserName(userRequest.getCommentFrom())
                    .build();
            commentRepository.save(comment);
        }

        else{
            Comment comment = Comment.builder()
                    .message(userRequest.getMessage())
                    .commentDateTime(LocalDateTime.now())
                    .postedByUserId(toUser.getUserId())
                    .postedForUserName(userRequest.getCommentTo())
                    .postedByUserName(userRequest.getCommentFrom())
                    .build();
            commentRepository.save(comment);
        }

        return new ResponseEntity<>("Comment Added Successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CommentResponse>> getAllComments(CommentRequest commentRequest) {

        List<Comment> comments = commentRepository.findByPostedForUserName(commentRequest.getCommentTo());
        if(comments == null) throw new RuntimeException("No Comments Exist For This User");

        List<CommentResponse> commentResponses = comments.stream()
                .map(comment -> {
                    CommentResponse commentResponse = new CommentResponse();
                    commentResponse.setCommentDateTime(comment.getCommentDateTime());
                    commentResponse.setMessage(comment.getMessage());
                    commentResponse.setPostedByUserName(comment.getPostedByUserName());
                    return commentResponse;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(commentResponses,HttpStatus.FOUND);
    }
}
