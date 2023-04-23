/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.funix.ngantcbfx05738.MyBlogs.controller;

import com.funix.ngantcbfx05738.MyBlogs.service.CategoryService;
import com.funix.ngantcbfx05738.MyBlogs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author baong
 */
@Controller
public class CategoryController {

    @Autowired
    CategoryService cService;
    
    @Autowired
    PostService pService;

    @RequestMapping("/category")
    public String category(Model model) {
        model.addAttribute("categories", cService.getAllCategories());
        return "category";
    }
    
    // list of post by category id
    @RequestMapping("/category/{id}")
    public String showPostByCategory(@PathVariable Long id, Model model) {
        
        // category title
        model.addAttribute("category", cService.getCategoryById(id));
        
        // list of post
        model.addAttribute("posts", pService.getPostsByCategoryId(id));
        
        // base
        model.addAttribute("latestPosts", pService.getTopThreeLatestPost());
        model.addAttribute("categories", cService.getAllCategories());
        return "post-list";
    }
}
