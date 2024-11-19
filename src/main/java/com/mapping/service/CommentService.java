package com.mapping.service;

import com.mapping.entity.Comment;
import com.mapping.entity.Post;
import com.mapping.repository.CommentRepository;
import com.mapping.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository,
                          PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public Comment addComment(Long postId, Comment comment) {
        // find post by id then get
        Post post = postRepository.findById(postId).get();

        // linked the comment with post which is find by id in above line
        comment.setPost(post);
        return commentRepository.save(comment);

    }

    public boolean deleteCommentByIdAndPostId(Long id,Long postId) {
        Optional<Comment> Comment = commentRepository.findByIdAndPostId(id, postId);
        if (Comment.isPresent()){
            commentRepository.delete(Comment.get());
            return true;
        }else {
            return false;
        }
    }

    public List<Comment> getAllComment(
            Long postId
    ) {
        List<Comment> comment = commentRepository.findByPostId(postId);
        if (comment.isEmpty()) {
            return new ArrayList<>();
        }else {
            return comment;
        }
    }
}
