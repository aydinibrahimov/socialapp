package com.aydinibrhmv.socialapp.controller;


import com.aydinibrhmv.socialapp.domain.Comment;
import com.aydinibrhmv.socialapp.request.CommentCreateRequest;
import com.aydinibrhmv.socialapp.request.CommentUpdateRequest;
import com.aydinibrhmv.socialapp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/comments")
@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        return commentService.getAllCommentWithParam(userId, postId);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest commentCreateRequest) {
        return commentService.createOneComment(commentCreateRequest);
    }

    @PutMapping("/{commentId}")
    public Comment updateOneComment(@RequestBody CommentUpdateRequest commentUpdateRequest, @PathVariable Long commentId) {
        return commentService.updateOneCommentById(commentUpdateRequest, commentId);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId) {
        return commentService.getOneCommentById(commentId);
    }

    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId) {
        commentService.deleteOneCommentById(commentId);
    }
}
