package com.quick.service;

import com.quick.entity.Post;
import java.util.List;

public interface PostService {
    List<Post> findAll();

    Post create(Post post);

    Post addCommentToPost(int postId, int commentId);
}
