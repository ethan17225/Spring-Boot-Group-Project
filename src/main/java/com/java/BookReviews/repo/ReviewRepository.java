package com.java.BookReviews.repo;

import com.java.BookReviews.models.Review;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for managing Review entities.
 * - Added new method findAllReviewByBookId(int bookId) to return all Review of 
 * a Book
 *
 * @author The Hai Nguyen - December 06, 2024
 */
public interface ReviewRepository extends CrudRepository<Review, Integer>{
    List<Review> findAllReviewByBookId(int bookId);
}
