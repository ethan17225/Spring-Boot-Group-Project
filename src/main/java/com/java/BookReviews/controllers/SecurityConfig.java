/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.BookReviews.controllers;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

/**
 *
 * @author theha
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails bob = User.withUsername("bob")
            .password(passwordEncoder().encode("pass"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(bob);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
    throws Exception {
        http.authorizeHttpRequests(auth -> auth
//        .requestMatchers("/newBook").hasRole("USER")
//        .requestMatchers("/newReview").hasRole("USER")
        .requestMatchers("/newBook/**").permitAll() //Need to be removed after testing
        .requestMatchers("/newReview/**").permitAll() //Need to be removed after testing
        .requestMatchers("/").permitAll()
        .requestMatchers("/books/**").permitAll()
        .requestMatchers(PathRequest.toH2Console()).permitAll()
        .anyRequest().authenticated())
        .httpBasic(withDefaults())
        .formLogin(withDefaults());
        
        http.csrf((csrf) -> csrf.disable());
        http.headers((headers) -> headers.frameOptions((frame) -> frame.sameOrigin()));
        
        return http.build();
    }

    
}
