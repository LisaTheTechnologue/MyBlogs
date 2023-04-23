/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.funix.ngantcbfx05738.MyBlogs.controller;

import com.funix.ngantcbfx05738.MyBlogs.model.Category;
import com.funix.ngantcbfx05738.MyBlogs.model.Post;
import com.funix.ngantcbfx05738.MyBlogs.service.CategoryService;
import com.funix.ngantcbfx05738.MyBlogs.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author baong
 */
@Controller
public class PostController {

    @Autowired
    CategoryService cService;

    @Autowired
    PostService pService;

    @GetMapping("/post/create")
    public String createPost(Model model) {

        // form
        model.addAttribute("post", new Post());
        List<Category> categories = cService.getAllCategories();
        model.addAttribute("categoriesddl", categories);

        // base
        model.addAttribute("categories", cService.getAllCategories());

        return "post-create";
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post,Model model) {

        // base
        model.addAttribute("categories", cService.getAllCategories());

        // current post
        pService.save(post);
        return "redirect:/";

    }

    @RequestMapping("/post/{id}")
    public String showPostDetails(@PathVariable Long id, Model model) {

        // current post
        model.addAttribute("post", pService.getPostById(id));

        // base
        model.addAttribute("latestPosts", pService.getTopThreeLatestPost());
        model.addAttribute("categories", cService.getAllCategories());

        return "post";
    }

}
