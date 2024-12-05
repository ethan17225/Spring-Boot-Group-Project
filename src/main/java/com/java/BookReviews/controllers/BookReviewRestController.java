/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.BookReviews.controllers;

import com.java.BookReviews.models.Book;
import com.java.BookReviews.models.Review;
import com.java.BookReviews.repo.BookRepository;
import com.java.BookReviews.repo.ReviewRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author theha
 */
@RestController
public class BookReviewRestController {
    @Autowired
    BookRepository bookRepo;
    
    @Autowired
    ReviewRepository reviewRepo;
    
    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId){
        System.out.println("GEtting book "+bookId);
        
        Book book = bookRepo.findById(bookId).get();
        System.out.println("Got book "+book);
        return book;
    }
    
    @GetMapping("/reviews/{bookId}")
    public List<Review> getReviews(@PathVariable int bookId){
        return (List<Review>) reviewRepo.findAllReviewByBookId(bookId);
    }
}
