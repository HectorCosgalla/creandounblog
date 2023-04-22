package com.valcos98.creandounblog.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.valcos98.creandounblog.Services.AccountServices;
import com.valcos98.creandounblog.Services.PostServices;
import com.valcos98.creandounblog.models.Account;
import com.valcos98.creandounblog.models.Post;

@Component
public class SeedData implements CommandLineRunner{
    
    @Autowired
    private PostServices postServices;

    @Autowired
    private AccountServices accountServices;

    @Override
    public void run(String... args){
        List<Post> posts = postServices.getAll();
        
        if (posts.size() == 0) {
            Account adminAccount = new Account();
            adminAccount.setFirstName("super");
            adminAccount.setLastName("admin");
            adminAccount.setEmail("admin@superadmin.com");
            adminAccount.setPassword("admin");
            accountServices.save(adminAccount);
            
            Post post1 = new Post();
            post1.setTitle("first Posts");
            post1.setBody("A post Bitch");
            post1.setAccount(adminAccount);

            Post post2 = new Post();
            post2.setTitle("Second post");
            post2.setBody("Another post Bitch");
            post2.setAccount(adminAccount);
            
            
            postServices.save(post1);
            postServices.save(post2);
        }
    }
}
