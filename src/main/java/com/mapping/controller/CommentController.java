package com.mapping.controller;

import com.mapping.entity.Comment;
import com.mapping.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
@Tag(name = "Comment Api", description = "Operations related to comment on related post")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(
            summary = "Add a new comment",
            description = "Add a comment to a specific post by providing the post ID and comment details."
    )
    @PostMapping
    public String addComment(
            @RequestParam Long postId,
            @RequestBody Comment comment
    ) {
        commentService.addComment(postId, comment);
        return "Comment is saved!";
    }
}
