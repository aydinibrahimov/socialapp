package com.aydinibrhmv.socialapp.repository;

import com.aydinibrhmv.socialapp.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
   List<Like> findByUserId(Long user);
   List<Like> findByPostId(Long post);

}
