package com.quick.rest;

import com.quick.entity.Post;
import com.quick.service.PostService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE,
                 produces = APPLICATION_JSON_VALUE)
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Post> findAll() {
        return postService.findAll();
    }

    @PostMapping("/{postId}/comment/{commentId}")
    public Post create(@PathVariable("postId") int postId,
                       @PathVariable("commentId") int commentId) {
        return postService.addCommentToPost(postId, commentId);
    }
}
