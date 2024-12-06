package com.java.BookReviews.service;

import com.java.BookReviews.models.MyUserDetails;
import com.java.BookReviews.repo.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Implementation of the UserDetailsService interface for managing user authentication.
 * This class interacts with the UserDetailsRepository to load user details by username 
 * for authentication purposes.
 * 
 * @author The Hai Nguyen - December 06, 2024
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserDetailsRepository userRepository; // Repository to access user data

    /**
     * Loads the user details by username for authentication.
     * If the user is not found, a UsernameNotFoundException is thrown.
     * 
     * @param username the username of the user to load
     * @return the UserDetails object for the user
     * @throws UsernameNotFoundException if the user is not found in the repository
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUserDetails mud = userRepository.findUserByUsername(username); // Find user by username
        if (mud == null) throw new UsernameNotFoundException("User not found"); // User not found, throw exception
        return mud; // Return the found user details
    }
}

