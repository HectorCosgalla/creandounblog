package com.valcos98.creandounblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valcos98.creandounblog.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
    
}
