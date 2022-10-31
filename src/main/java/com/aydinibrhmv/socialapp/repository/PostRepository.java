package com.aydinibrhmv.socialapp.repository;

import com.aydinibrhmv.socialapp.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
