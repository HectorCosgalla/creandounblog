package com.valcos98.creandounblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valcos98.creandounblog.Services.AccountServices;
import com.valcos98.creandounblog.models.Account;

@Controller
public class RegisterController {
    @Autowired
    private AccountServices accountServices;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute Account account){
        accountServices.save(account);

        return "redirect:/";
    }
}
