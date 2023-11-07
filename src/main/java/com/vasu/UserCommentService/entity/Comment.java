package com.vasu.UserCommentService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "comment_table")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "comment_date_time", nullable = false)
    private LocalDateTime commentDateTime;

    private Long postedByUserId;

    private String postedForUserName;

    private String postedByUserName;
}
