package com.valcos98.creandounblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/creandounblog")
    public String minimain(Model model){
        return "home";
    }

    @GetMapping("/posts/primer_post")
    public String primerPost(Model model){
        return "/posts/primer_post";
    }
    
}
