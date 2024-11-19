package com.mapping.service;

import com.mapping.entity.Post;
import com.mapping.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean deletePostById(Long id) {
       if (postRepository.existsById(id)){
           postRepository.deleteById(id);
           return true;
        }else {
           return false;
       }
    }

    public List<Post> getAllPost() {
        List<Post> allPost = postRepository.findAll();
        return allPost;
    }
}
