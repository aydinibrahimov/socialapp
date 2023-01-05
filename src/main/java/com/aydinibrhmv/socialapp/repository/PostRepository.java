package com.aydinibrhmv.socialapp.repository;

import com.aydinibrhmv.socialapp.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    List<Post> findByUserId(Long user);
}
