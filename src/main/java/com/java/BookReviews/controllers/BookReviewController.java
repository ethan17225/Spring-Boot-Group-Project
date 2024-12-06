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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author theha
 */
@Controller
public class BookReviewController {
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
    
    @RequestMapping("/newReview/{bookId}")
    public String newReview(Model model, @PathVariable int bookId) {
        model.addAttribute("bookId", bookId);
        model.addAttribute("book", bookRepo.findById(bookId).get());
        
        return "addReview";
    }
    
    @RequestMapping("/addReview/{bookId}")
    public String addReview(Model model, @PathVariable int bookId, @RequestParam String review){
        Review newReview = new Review();
        newReview.setBookId(bookId);
        newReview.setReview(review);
        
        reviewRepo.save(newReview);
        
        return "redirect:/";
    }
}
