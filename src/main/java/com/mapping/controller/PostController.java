package com.mapping.controller;

import com.mapping.entity.Post;
import com.mapping.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
@Tag(name = "Post Api", description = "Operations related to Post anything with title")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(
            summary = "Create a new post",
            description = "Add a new post to the system by providing post details"
    )
    @PostMapping
    public ResponseEntity<String> createPost(
            @RequestBody Post post
    ) {
        Post createdPost = postService.createpost(post);
        return new ResponseEntity<>("Post saved with ID: " + createdPost.getId(), HttpStatus.CREATED);
    }
}
