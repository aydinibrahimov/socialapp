package com.aydinibrhmv.socialapp.controller;

import com.aydinibrhmv.socialapp.domain.Like;
import com.aydinibrhmv.socialapp.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes/")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @GetMapping
    public List<Like> getAllLikes(@RequestParam(name = "uid") Optional<Long> userId, @RequestParam Optional<Long>  postId) {
       return likeService.getAllLikes(userId.get(),postId.get());

    }
}
