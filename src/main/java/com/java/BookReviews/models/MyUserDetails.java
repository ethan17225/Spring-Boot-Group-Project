package com.java.BookReviews.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Arrays;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Entity class that implements the UserDetails interface to represent user details 
 * for authentication and authorization purposes in a Spring Security context.
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
public class MyUserDetails implements UserDetails {

    /**
     * The unique identifier for the user.
     * This ID is auto-generated using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The username of the user, used for login.
     */
    private String username;

    /**
     * The password of the user, stored securely (should be encrypted).
     */
    private String password;

    /**
     * The roles assigned to the user (e.g., "ROLE_USER, ROLE_ADMIN").
     * Roles are stored as a comma-separated string.
     */
    private String roles;

    /**
     * Provides a PasswordEncoder bean to encode passwords securely.
     * In this case, BCryptPasswordEncoder is used for hashing.
     * 
     * @return an instance of BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Retrieves the encoded password for the user.
     * Overrides the default `getPassword` method from UserDetails.
     * 
     * @return the encoded password
     */
    @Override
    public String getPassword() {
        return passwordEncoder().encode(password);
    }

    /**
     * Retrieves the roles of the user as a collection of GrantedAuthority objects.
     * 
     * @return a collection of authorities granted to the user
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(getRoles());
        return Arrays.asList(authority);
    }

    /**
     * Indicates whether the user's account is expired.
     * 
     * @return true (always enabled in this implementation)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user's account is locked.
     * 
     * @return true (always unlocked in this implementation)
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (e.g., password) are expired.
     * 
     * @return true (always valid in this implementation)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled (active).
     * 
     * @return true (always enabled in this implementation)
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
