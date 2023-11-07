package com.vasu.UserCommentService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResponse {
    private String message;
    private LocalDateTime commentDateTime;
    private String postedByUserName;
}
