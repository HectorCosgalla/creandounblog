package com.valcos98.creandounblog.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valcos98.creandounblog.models.Post;
import com.valcos98.creandounblog.repositories.PostRepository;

@Service
public class PostServices {

    @Autowired
    private PostRepository postRepository;

    public Optional<Post> getById(Long id){
        return postRepository.findById(id);
    }

    public List<Post> getAll(){
        return postRepository.findAll();
    }

    public Post save(Post post){
        if (post.getId() == null) {
            post.setCreatedAt(LocalDateTime.now());
        }

        return postRepository.save(post);
    }
}
