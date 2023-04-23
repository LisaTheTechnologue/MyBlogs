/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.funix.ngantcbfx05738.MyBlogs.service;

import com.funix.ngantcbfx05738.MyBlogs.model.Category;
import com.funix.ngantcbfx05738.MyBlogs.repo.CategoryRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author baong
 */
@Service
public class CategoryService {
    
    @Autowired
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        if (categories != null) {
            return categories;
        } else {
            return null;
        }
    }
    
    public Category getCategoryById(Long categoryId) {
        try {
            Category category = categoryRepo.findById(categoryId).get();
            return category;
        } catch (Exception e) {
            return null;
        }
    }
    
}
