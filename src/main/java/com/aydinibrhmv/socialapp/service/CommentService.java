package com.aydinibrhmv.socialapp.service;

import com.aydinibrhmv.socialapp.domain.Comment;
import com.aydinibrhmv.socialapp.domain.Post;
import com.aydinibrhmv.socialapp.domain.User;
import com.aydinibrhmv.socialapp.repository.CommentRepository;
import com.aydinibrhmv.socialapp.request.CommentCreateRequest;
import com.aydinibrhmv.socialapp.request.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;
    public CommentService(CommentRepository commentRepository,PostService postService,UserService userService){
        this.commentRepository=commentRepository;
        this.userService=userService;
        this.postService=postService;
    }


    public List<Comment> getAllCommentWithParam(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent()){
            return commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
        }else if(userId.isPresent()){
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());

        }else {
           return commentRepository.findAll();
        }
    }

    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {
        Post post=postService.getOnePostById(commentCreateRequest.getPostId());
        User user=userService.getOneUserById(commentCreateRequest.getUserId());
        if(user!=null&&post!=null){

            Comment comment=new Comment();
            comment.setText(commentCreateRequest.getText());
            comment.setPostId(post);
            comment.setUserId(user);
            return commentRepository.save(comment);
        }else
        return null;
    }

    public Comment updateOneCommentById(CommentUpdateRequest commentUpdateRequest,Long commentId) {
        Optional<Comment> comment=commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment updateComment=comment.get();
            updateComment.setText(commentUpdateRequest.getText());
            return commentRepository.save(updateComment);
        }
        return null;
    }

    public void deleteOneCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
