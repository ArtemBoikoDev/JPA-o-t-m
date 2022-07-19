package com.quick.rest;

import com.quick.entity.Comment;
import com.quick.service.CommentService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE,
                 produces = APPLICATION_JSON_VALUE)
    public Comment create(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Comment> findAll() {
        return commentService.findAll();
    }

    @GetMapping(value = "/post/{postId}",
                produces = APPLICATION_JSON_VALUE)
    public List<Comment> findAllByPostId(@PathVariable("postId") int postId) {
        return commentService.findAllByPost(postId);
    }
}
