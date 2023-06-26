package com.aydinibrhmv.socialapp.controller;

import com.aydinibrhmv.socialapp.domain.Post;
import com.aydinibrhmv.socialapp.request.PostCreateRequest;
import com.aydinibrhmv.socialapp.request.PostUpdateRequest;
import com.aydinibrhmv.socialapp.response.PostResponse;
import com.aydinibrhmv.socialapp.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postservice) {
        this.postService = postservice;
    }


    @GetMapping()
    public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostCreateRequest) {
        return postService.createOnePost(newPostCreateRequest);
    }


    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
        return postService.updateOnePostById(postId, updatePost);

    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId) {
        postService.deleteOnePost(postId);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId) {
        return postService.getOnePostById(postId);
    }

}
