package com.aydinibrhmv.socialapp.service;

import com.aydinibrhmv.socialapp.domain.Like;
import com.aydinibrhmv.socialapp.enums.CustomErrorCode;
import com.aydinibrhmv.socialapp.exception.CustomException;
import com.aydinibrhmv.socialapp.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final PostService postService;
    private final UserService userService;
    private final CommentService commentService;

    public List<Like> getAllLikes(Long userId, Long postId) {
        if (postId != null && userId != null) {
            return likeRepository.findByUserIdAndPostId(userId, postId);

        } else if (userId != null) {
            return likeRepository.findByUserId(userId);

        } else if (postId != null) {
            return likeRepository.findByPostId(postId);
        } else {
            return likeRepository.findAll();

        }
    }

    private  Like getLike(Long id){
        return likeRepository.findById(id)
                .orElseThrow(()->new CustomException(CustomErrorCode.LIKE_NOT_FOUND));
    }
}



