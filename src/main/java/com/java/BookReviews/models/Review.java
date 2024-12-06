package com.java.BookReviews.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a Review in the system.
 * A Review contains an auto-generated ID, a reference to the associated book, 
 * and the review content.
 * 
 * This class uses Lombok annotations for boilerplate code reduction:
 * - @Data generates getters, setters, `toString`, `equals`, and `hashCode` methods.
 * - @AllArgsConstructor generates a constructor with all fields as parameters.
 * - @NoArgsConstructor generates a no-argument constructor.
 * 
 * @author The Hai Nguyen - December 06, 2024
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    /**
     * The unique identifier for the review.
     * This ID is auto-generated using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The ID of the book that this review is associated with.
     * This acts as a foreign key referencing the Book entity.
     */
    private int bookId;

    /**
     * The content of the review written by a user.
     */
    private String review;
}

