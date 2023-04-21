package com.valcos98.creandounblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.valcos98.creandounblog.Services.PostServices;
import com.valcos98.creandounblog.models.Post;



@Controller
public class HomeController {
    @Autowired
    private PostServices postServices;

    @GetMapping("/")
    public String home(Model model){
        List<Post> posts = postServices.getAll();
        model.addAttribute("posts", posts);
        return "home";
    }
}
