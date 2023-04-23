/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.funix.ngantcbfx05738.MyBlogs.repo;

import com.funix.ngantcbfx05738.MyBlogs.model.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author baong
 */
@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    Post findFirstByOrderByCreatedAtDesc();
    
    List<Post> findTop3ByOrderByCreatedAtDesc();
    
    List<Post> findByCategoryId(Long id);
    
    Optional<Post> findById(Long id);
}