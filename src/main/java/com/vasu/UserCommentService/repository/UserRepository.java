package com.vasu.UserCommentService.repository;

import com.vasu.UserCommentService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.commentFrom = :commentName OR u.commentTo = :commentName")
    User findCommonNameInCommentsFromTo(@Param("commentName") String commentName);
}
