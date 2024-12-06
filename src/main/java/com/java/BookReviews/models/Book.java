package com.java.BookReviews.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Entity class representing a Book in the system.
 * A Book contains an auto-generated ID, a title, and a list of authors.
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
public class Book {
    /**
     * The unique identifier for the book.
     * This ID is auto-generated using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The title of the book.
     */
    private String title;

    /**
     * The authors of the book, stored as a single string (e.g., "Author1, Author2").
     */
    private String authors;
}
