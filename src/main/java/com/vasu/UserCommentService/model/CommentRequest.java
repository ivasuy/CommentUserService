package com.vasu.UserCommentService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequest {
    @Column(name = "comment_to", length = 25, nullable = false)
    private String commentTo;
}
