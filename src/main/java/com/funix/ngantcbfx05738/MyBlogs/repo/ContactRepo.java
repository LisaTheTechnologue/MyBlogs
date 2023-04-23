/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.funix.ngantcbfx05738.MyBlogs.repo;

import com.funix.ngantcbfx05738.MyBlogs.model.Contact;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author baong
 */
@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {
    Optional<Contact> findById(Long Id);
}
