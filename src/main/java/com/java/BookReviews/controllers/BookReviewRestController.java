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
 * REST Controller for handling API endpoints related to books and reviews.
 * Provides endpoints to fetch details of a book and its associated reviews.
 * 
 * @author The Hai Nguyen - December 06, 2024
 */
@RestController
public class BookReviewRestController {

    // Repository for accessing book data
    @Autowired
    BookRepository bookRepo;

    // Repository for accessing review data
    @Autowired
    ReviewRepository reviewRepo;

    /**
     * Fetches the details of a specific book by its ID.
     * 
     * @param bookId the ID of the book to retrieve
     * @return the Book object associated with the provided ID
     */
    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {
        System.out.println("Getting book with ID: " + bookId);

        // Retrieve the book from the repository
        Book book = bookRepo.findById(bookId).orElse(null);

        // Log and return the book details
        System.out.println("Retrieved book: " + book);
        return book;
    }

    /**
     * Fetches all reviews associated with a specific book ID.
     * 
     * @param bookId the ID of the book whose reviews are to be retrieved
     * @return a list of Review objects associated with the book
     */
    @GetMapping("/reviews/{bookId}")
    public List<Review> getReviews(@PathVariable int bookId) {
        // Retrieve all reviews for the specified book ID
        return (List<Review>) reviewRepo.findAllReviewByBookId(bookId);
    }
}
