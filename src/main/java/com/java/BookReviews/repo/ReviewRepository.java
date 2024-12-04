/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.BookReviews.repo;

import com.java.BookReviews.models.Review;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author theha
 */
public interface ReviewRepository extends CrudRepository<Review, Integer>{
    List<Review> findAllReviewByBookId(int bookId);
}
