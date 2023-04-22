package com.valcos98.creandounblog.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.valcos98.creandounblog.Services.AccountServices;
import com.valcos98.creandounblog.Services.PostServices;
import com.valcos98.creandounblog.models.Account;
import com.valcos98.creandounblog.models.Post;


@Controller
public class PostController {
    
    @Autowired
    private PostServices postServices;

    @Autowired
    private AccountServices accountServices;

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

    @GetMapping("/posts/new")
    public String createAPost(Model model){
        String returnedPage = "";
        Optional<Account> optionalAccount = accountServices.getAccountById((long) 1);
        if (optionalAccount.isPresent()) {
            Post post = new Post();
            post.setAccount(optionalAccount.get());
            model.addAttribute("post", post);
            returnedPage = "new-post";
        } else{
            returnedPage = "404";
        }
        
        return returnedPage;
    }

    @PostMapping("/posts/new")
    public String postNewPost(@ModelAttribute Post post){
        postServices.save(post);
        return "redirect:/";
    }
}
