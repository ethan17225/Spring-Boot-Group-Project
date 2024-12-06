package com.java.BookReviews.security;

import com.java.BookReviews.service.UserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Configuration class for Spring Security.
 * This class defines security policies, user authentication, and password encoding mechanisms.
 * 
 * @author The Hai Nguyen - December 06, 2024
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the password encoder bean using BCryptPasswordEncoder.
     * 
     * @return a PasswordEncoder instance
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the UserDetailsService bean for user management.
     * 
     * @return an instance of UserDetailsServiceImpl
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    /**
     * Configures the security filter chain to handle HTTP request authorization rules.
     * 
     * @param http the HttpSecurity object to configure
     * @return a configured SecurityFilterChain
     * @throws Exception if any error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
            .requestMatchers("/newBook").authenticated() // Only authenticated users can add new books
            .requestMatchers("/books/**").permitAll()    // All users can fetch book information
            .requestMatchers("/newReview/**").permitAll() // All users can access the page for adding a new review
            .requestMatchers("/addReview/**").permitAll() // All users can submit a new review
            .requestMatchers("/reviews/**").permitAll()   // All users can view reviews for a book
            .requestMatchers("/").permitAll()             // All users can access the homepage
            .requestMatchers(PathRequest.toH2Console()).permitAll() // All users can access the H2 console (for development)
            .anyRequest().authenticated())                
            .httpBasic(withDefaults())
            .formLogin(withDefaults());

        http.csrf(csrf -> csrf.disable()); // Disables CSRF protection (not recommended for production)
        http.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())); // Allows H2 console to load properly

        return http.build();
    }

    /**
     * Configures the AuthenticationManager bean with a DaoAuthenticationProvider.
     * This manages user authentication using the UserDetailsService and PasswordEncoder.
     * 
     * @return a configured AuthenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authenticationProvider);
    }
}


