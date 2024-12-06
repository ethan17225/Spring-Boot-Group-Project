package com.java.BookReviews.repo;

import com.java.BookReviews.models.MyUserDetails;
import org.springframework.data.repository.CrudRepository;
/**
 * Repository interface for managing MyUserDetails entities.
 *
 * @author The Hai Nguyen - December 06, 2024
 */
public interface UserDetailsRepository extends CrudRepository<MyUserDetails, Integer>{
    public MyUserDetails findUserByUsername(String username);
}
