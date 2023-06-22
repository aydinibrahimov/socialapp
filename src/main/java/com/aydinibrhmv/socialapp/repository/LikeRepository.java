package com.aydinibrhmv.socialapp.repository;

import com.aydinibrhmv.socialapp.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
   List<Like> findByUserIdAndPostId(Long userId,Long postId);
   List<Like> findByPostId(Long postId);
   List<Like> findByUserId(Long userId);


}
