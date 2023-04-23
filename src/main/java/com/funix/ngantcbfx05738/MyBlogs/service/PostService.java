/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.funix.ngantcbfx05738.MyBlogs.service;

import com.funix.ngantcbfx05738.MyBlogs.model.Post;
import com.funix.ngantcbfx05738.MyBlogs.repo.PostRepo;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author baong
 */
@Service
public class PostService {
    
    // variable
    final Integer IS_NOT_READ = 0;
    
    @Autowired
    private final PostRepo postRepo;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }    
    
    public List<Post> getAllPosts() {
        List<Post> posts = postRepo.findAll();
        return posts;
    }
    
    public List<Post> getPostsByCategoryId(Long categoryId) {
        List<Post> posts = postRepo.findByCategoryId(categoryId);
        if (posts != null) {
            return posts;
        } else {
            return null;
        }
    }
    
    public Post getPostById(Long id) {
        try {
            Post post = postRepo.findById(id).get();
            return post;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Post> getTopThreeLatestPost() {
        List<Post> posts = postRepo.findTop3ByOrderByCreatedAtDesc();
        if (posts != null) {
            return posts;
        } else {
            return null;
        }
    }
    
    public Post getLatestPost() {
        try {
            Post post = postRepo.findFirstByOrderByCreatedAtDesc();
            return post;
        } catch (Exception e) {
            return null;
        }
    }  
    
    public Post save(Post post) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            post.setCreatedAt(timestamp);
            post.setIsDeleted(IS_NOT_READ);
            post.setImageUrl(null);
            Post postDB = postRepo.save(post);
            return postDB;
        } catch (Exception e) {
            return null;
        }
    }
    
}
