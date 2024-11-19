package com.mapping.controller;

import com.mapping.entity.Comment;
import com.mapping.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<Comment> addComment(
            @RequestParam Long postId,
            @RequestBody Comment comment
    ) {
        Comment added = commentService.addComment(postId, comment);
      return  new ResponseEntity<>(added, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Comment Related to a Specific Post",
            description = "Deletes a comment by its ID that is associated with a specific post ID"
    )
    @DeleteMapping("/delete/{postId}/{id}")
    public ResponseEntity<String> deleteComment(
            @PathVariable Long id,
            @PathVariable Long postId
    ){
        boolean deleted = commentService.deleteCommentByIdAndPostId(id,postId);
        if (deleted){
            return ResponseEntity.ok("Comment deleted successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Comment with ID " + id + " not found");
        }
    }
    @Operation(
            summary = "Get All Comments for a Post",
            description = "Retrieve a list of all comments associated with the specified post ID."
    )
    @GetMapping("/Comments/{postId}")
    public ResponseEntity<?> lisAllComment(
            @PathVariable Long postId
    ){
        List<Comment> allComment = commentService.getAllComment(postId);
        if (allComment.isEmpty()) {
            return new ResponseEntity<>("No comments found for this post",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(allComment);
    }
}
