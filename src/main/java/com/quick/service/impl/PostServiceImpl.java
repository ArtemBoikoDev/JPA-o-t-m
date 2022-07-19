package com.quick.service.impl;

import com.quick.entity.Comment;
import com.quick.entity.Post;
import com.quick.repository.CommentRepository;
import com.quick.repository.PostRepository;
import com.quick.service.PostService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post addCommentToPost(int postId, int commentId) {
        Post post = postRepository.findById(postId)
                                  .orElseThrow(() -> new RuntimeException("No post with id:" +
                                                                          postId));
        System.out.println("post = " + post);
        Comment comment = commentRepository.findById(commentId)
                                           .orElseThrow(() -> new RuntimeException("No comment with id:" +
                                                                                   commentId));
        System.out.println("comment = " + comment);
        post.addComment(comment);
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
