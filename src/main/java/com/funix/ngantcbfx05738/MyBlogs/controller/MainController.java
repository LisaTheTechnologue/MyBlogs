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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author baong
 */
@Controller
public class MainController {
    
    @Autowired
    CategoryService cService;
    
    @Autowired
    PostService pService;

    @RequestMapping(value = {"/", "/index", "/home"}, method = RequestMethod.GET)
    public String index(Model model) {
        
        model.addAttribute("post", pService.getLatestPost());
        
        //base        
        model.addAttribute("latestPosts", pService.getTopThreeLatestPost());
        model.addAttribute("categories", cService.getAllCategories());
        return "index";
    }
        
}
