package com.aydinibrhmv.socialapp.repository;

import com.aydinibrhmv.socialapp.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findByUserId(Long userId);

    public List<Comment> findByPostId(Long postId);

    List<Comment> findByUserIdAndPostId(Long userId, Long postId);
}
