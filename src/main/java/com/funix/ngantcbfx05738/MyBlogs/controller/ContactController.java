/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.funix.ngantcbfx05738.MyBlogs.controller;

import com.funix.ngantcbfx05738.MyBlogs.model.Contact;
import com.funix.ngantcbfx05738.MyBlogs.service.CategoryService;
import com.funix.ngantcbfx05738.MyBlogs.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author baong
 */
@Controller
public class ContactController {
    
    @Autowired
    CategoryService ctgService;
    
    @Autowired
    ContactService cService;

    @GetMapping("/contact/create")
    public String contact(Model model) {
        
        // form
        model.addAttribute("contact", new Contact());
        
        // right col
        model.addAttribute("categories", ctgService.getAllCategories());
        
        return "contact";
    }
    
    @PostMapping("/contact/save")
    public String addContact(@ModelAttribute("contact") Contact contact,
            BindingResult result, Model model) {
        
        // right col
        model.addAttribute("categories", ctgService.getAllCategories());
        
        try {            
            Contact resultDB = cService.save(contact);
            if (resultDB==null) {
                model.addAttribute("isSuccess", false);
                return "redirect:contact-result";
            } else return "redirect:/contact-result/"+resultDB.getId();
        } catch (Exception ex) {
            System.out.println( ex);
            model.addAttribute("isSuccess", false);
            return "redirect:contact-result";
        }     
        
    }
    
    @GetMapping("/contact-result/{id}")
    public String contactResult(@PathVariable Long id, Model model) {
        
        model.addAttribute("contact", cService.getContact(id));
        
        // right col
        model.addAttribute("categories", ctgService.getAllCategories());
        
        return "contact-result";
    }
}
