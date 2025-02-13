package com.workout.befit.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.workout.befit.services.CustomUserDetails;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CustomUserDetails customUserDetailsService;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public CustomAuthenticationProvider(CustomUserDetails customUserDetailsService, PasswordEncoder passwordEncoder) {
        this.customUserDetailsService = customUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        
        // Fetch user details
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        
        // Check if the password matches
        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
        }
        
        throw new AuthenticationException("Invalid username or password") {};
    }
    

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

