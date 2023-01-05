package com.aydinibrhmv.socialapp.response;

import com.aydinibrhmv.socialapp.domain.Post;
import lombok.Data;

@Data
public class PostResponse {

    private Long id;
    private Long userid;
    private String userName;
    private String title;
    private String text;


    public PostResponse(Post post) {

        this.id = post.getPostId();
        this.userid = post.getUser().getId();
        this.userName=post.getUser().getFirstname();
        this.title = post.getTitle();
        this.text = post.getText();

    }
}
