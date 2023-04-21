package com.valcos98.creandounblog.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.valcos98.creandounblog.Services.PostServices;
import com.valcos98.creandounblog.models.Post;

@Component
public class SeedData implements CommandLineRunner{
    
    @Autowired
    private PostServices postServices;

    @Override
    public void run(String... args){
        List<Post> posts = postServices.getAll();
        
        if (posts.size() == 0) {
            Post post1 = new Post();
            post1.setTitle("first Posts");
            post1.setBody("A post Bitch");

            Post post2 = new Post();
            post2.setTitle("Second post");
            post2.setBody("Another post Bitch");
            
            postServices.save(post1);
            postServices.save(post2);
        }
    }
}
