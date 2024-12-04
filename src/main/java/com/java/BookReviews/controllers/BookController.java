/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.BookReviews.controllers;

import com.java.BookReviews.models.Book;
import com.java.BookReviews.repo.BookRepository;
import com.java.BookReviews.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author theha
 */
@Controller
public class BookController {
    @Autowired
    BookRepository bookRepo;
    
    @Autowired
    ReviewRepository reviewRepo;
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("books", bookRepo.findAll());
    }
}
