/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.BookReviews.service;

import com.java.BookReviews.models.MyUserDetails;
import com.java.BookReviews.repo.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author theha
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDetailsRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
        MyUserDetails mud = userRepository.findUserByUsername(username);
        if (mud == null) throw new UsernameNotFoundException("User not found");
        return mud;
    }
}

