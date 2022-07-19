package com.quick.service;

import com.quick.entity.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment create(Comment comment);

    List<Comment> findAllByPost(int postId);
}
