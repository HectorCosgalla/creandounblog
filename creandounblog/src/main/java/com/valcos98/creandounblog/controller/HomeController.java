package com.valcos98.creandounblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("../")
    public String minimain(Model model){
        return "index";
    }

    @GetMapping("/posts/primer_post")
    public String primerPost(Model model){
        return "/posts/primer_post";
    }
    
}
