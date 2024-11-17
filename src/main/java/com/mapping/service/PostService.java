package com.mapping.service;

import com.mapping.entity.Post;
import com.mapping.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private  PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createpost(Post post) {
        Post save = postRepository.save(post);
        return save;
    }
}
