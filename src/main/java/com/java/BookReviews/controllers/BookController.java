/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.BookReviews.controllers;

import com.java.BookReviews.models.Book;
import com.java.BookReviews.models.Review;
import com.java.BookReviews.repo.BookRepository;
import com.java.BookReviews.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return "index";
    }
    
    @RequestMapping("/newBook")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        
        return "addBook";
    }
    
    @RequestMapping("/addBook")
    public String addBook(Model model, @ModelAttribute Book book){
        bookRepo.save(book);
        
        return "redirect:/";
    }
    
    @RequestMapping("/newReview")
    public String newReview(Model model) {
        model.addAttribute("review", new Review());
        
        return "addBook";
    }
    
    @RequestMapping("/addReview")
    public String addReview(Model model, @ModelAttribute Review review){
        reviewRepo.save(review);
        
        return "redirect:/";
    }
}
