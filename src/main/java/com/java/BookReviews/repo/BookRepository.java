package com.java.BookReviews.repo;

import com.java.BookReviews.models.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for managing Book entities.
 *
 * @author The Hai Nguyen - December 06, 2024
 */
public interface BookRepository extends CrudRepository<Book, Integer> {
    
}
