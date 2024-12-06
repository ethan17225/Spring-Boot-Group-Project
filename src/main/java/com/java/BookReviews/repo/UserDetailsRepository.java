/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.BookReviews.repo;

import com.java.BookReviews.models.MyUserDetails;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author theha
 */
public interface UserDetailsRepository extends CrudRepository<MyUserDetails, Integer>{
    public MyUserDetails findUserByUsername(String username);
}
