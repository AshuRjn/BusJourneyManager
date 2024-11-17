package com.mapping.service;

import com.mapping.entity.Comment;
import com.mapping.entity.Post;
import com.mapping.repository.CommentRepository;
import com.mapping.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository,
                          PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public void addComment(Long postId, Comment comment) {
        // find post by id then get
        Post post = postRepository.findById(postId).get();

        // linked the comment with post which is find bi id in above line
        comment.setPost(post);
        Comment savecmt = commentRepository.save(comment);

    }
}
