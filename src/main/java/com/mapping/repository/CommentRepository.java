package com.mapping.repository;

import com.mapping.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findByIdAndPostId(Long id, Long postId);
    List<Comment> findByPostId(Long postId);

}