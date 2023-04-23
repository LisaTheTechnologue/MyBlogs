/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.funix.ngantcbfx05738.MyBlogs.service;

import com.funix.ngantcbfx05738.MyBlogs.model.Contact;
import com.funix.ngantcbfx05738.MyBlogs.repo.ContactRepo;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author baong
 */
@Service
public class ContactService {

    // variable
    final Integer IS_NOT_READ = 0;

    @Autowired
    private final ContactRepo contactRepo;

    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public Contact getContact(Long id) {
        try {
            Contact contact = contactRepo.findById(id).get();
            return contact;
        } catch (Exception e) {
            return null;
        }
    }

    public Contact save(Contact contact) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        contact.setCreatedAt(timestamp);
        contact.setIsRead(IS_NOT_READ);
        
        Contact contactDB = contactRepo.save(contact);
        return contactDB;
    }
}
