package com.vasu.UserCommentService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    @Column(name = "comment_from", length = 25, nullable = false)
    private String commentFrom;

    @Column(name = "comment_to", length = 25, nullable = false)
    private String commentTo;

    @NotBlank(message = "Message should not be empty")
    @Column(name = "message", nullable = false)
    private String message;
}
