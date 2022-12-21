package com.aydinibrhmv.socialapp.service;

import com.aydinibrhmv.socialapp.domain.Post;
import com.aydinibrhmv.socialapp.domain.User;
import com.aydinibrhmv.socialapp.repository.PostRepository;
import com.aydinibrhmv.socialapp.request.PostCreateRequest;
import com.aydinibrhmv.socialapp.request.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService  {
    private PostRepository postRepository;
    private UserService userService;
    public PostService(PostRepository postRepository,UserService userService){
        this.postRepository=postRepository;
        this.userService=userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent())
            return postRepository.findByUserId(userId.get());
        return postRepository.findAll();
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostCreateRequest) {
      User user=  userService.getOneUser(newPostCreateRequest.getUserId());
        if(user==null)
            return null;
        Post toSave=new Post();
        toSave.setUserId(user);
        toSave.setText(newPostCreateRequest.getText());
        toSave.setTitle(newPostCreateRequest.getTitle());
        toSave.setPostId(newPostCreateRequest.getId());
        return postRepository.save(toSave);
    }



    public void deleteOnePost(Long postId) {
        postRepository.deleteById(postId);
    }

    public Post updateOnePostById(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post=postRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate=post.orElse(null);
            toUpdate.setText(postUpdateRequest.getText());
            toUpdate.setTitle(postUpdateRequest.getTitle());
             postRepository.save(toUpdate);
                return  toUpdate;
        }
        return null;
    }
}
