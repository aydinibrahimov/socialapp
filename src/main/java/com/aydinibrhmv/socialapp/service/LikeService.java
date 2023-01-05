package com.aydinibrhmv.socialapp.service;

import com.aydinibrhmv.socialapp.domain.Like;
import com.aydinibrhmv.socialapp.repository.LikeRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class LikeService {
    private LikeRepository likeRepository;
    private PostService postService;
    private UserService userService;

    public LikeService(LikeRepository likeRepository, PostService postService, UserService userService) {
        this.likeRepository = likeRepository;
        this.postService = postService;
        this.userService = userService;
    }

    public List<Like> getAllPostLikes(Long id) {
        List<Like> likes;
        if (postService.getOnePostById(id) != null){
            likes= likeRepository.findByPostId(id);
        return likes;}
        return likes=null;
    }

    public List<Like> getAllUserLikes(Long id) {
        List<Like> likes;
        if (userService.getOneUserById(id) != null) {
            likes = likeRepository.findByUserId(id);
            return likes;
        }
        return likes = null;
    }

    public Like getOneLikeById(Long id) {
        return likeRepository.findById(id).orElse(null);
    }


}
