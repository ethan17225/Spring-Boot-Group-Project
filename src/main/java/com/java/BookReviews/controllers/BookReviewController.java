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
 * Controller class for managing book reviews.
 * Provides endpoints for viewing, adding, and managing books and their reviews.
 * 
 * @author The Hai Nguyen - December 06, 2024
 */
@Controller
public class BookReviewController {
    // Repository for accessing book data
    @Autowired
    BookRepository bookRepo;

    // Repository for accessing review data
    @Autowired
    ReviewRepository reviewRepo;

    /**
     * Displays the homepage with a list of all books.
     *
     * @param model the Model object for passing data to the view
     * @return the name of the index template
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "index";
    }

    /**
     * Displays a form to create a new book.
     *
     * @param model the Model object for passing data to the view
     * @return the name of the addBook template
     */
    @RequestMapping("/newBook")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    /**
     * Handles the submission of a new book.
     *
     * @param model the Model object for passing data to the view
     * @param book  the Book object populated from the form submission
     * @return a redirect to the homepage
     */
    @RequestMapping("/addBook")
    public String addBook(Model model, @ModelAttribute Book book) {
        bookRepo.save(book);
        return "redirect:/";
    }

    /**
     * Displays a form to create a new review for a specific book.
     *
     * @param model  the Model object for passing data to the view
     * @param bookId the ID of the book to review
     * @return the name of the addReview template
     */
    @RequestMapping("/newReview/{bookId}")
    public String newReview(Model model, @PathVariable int bookId) {
        model.addAttribute("bookId", bookId);
        model.addAttribute("book", bookRepo.findById(bookId).get());
        return "addReview";
    }

    /**
     * Handles the submission of a new review for a specific book.
     *
     * @param model  the Model object for passing data to the view
     * @param bookId the ID of the book being reviewed
     * @param review the content of the review
     * @return a redirect to the homepage
     */
    @RequestMapping("/addReview/{bookId}")
    public String addReview(Model model, @PathVariable int bookId, @RequestParam String review) {
        // Create a new Review object and associate it with the given book ID
        Review newReview = new Review();
        newReview.setBookId(bookId);
        newReview.setReview(review);

        // Save the review to the database
        reviewRepo.save(newReview);

        return "redirect:/";
    }
}
