package com.valcos98.creandounblog.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.valcos98.creandounblog.Services.PostServices;
import com.valcos98.creandounblog.models.Post;


@Controller
public class PostController {
    
    @Autowired
    private PostServices postServices;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model){
        String returnedString = "";
        Optional<Post> optionalPost = postServices.getById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            returnedString = "post";
        } else{
            returnedString = "404";
        }
        
        return returnedString;
    }
}
