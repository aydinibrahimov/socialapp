package com.aydinibrhmv.socialapp.repository;

import com.aydinibrhmv.socialapp.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
