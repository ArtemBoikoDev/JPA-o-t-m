package com.quick.service.impl;

import com.quick.entity.Comment;
import com.quick.repository.CommentRepository;
import com.quick.service.CommentService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllByPost(int postId) {
        return commentRepository.findAllByPost_Id(postId);
    }
}
