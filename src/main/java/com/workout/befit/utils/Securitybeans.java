package com.workout.befit.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.workout.befit.services.CustomUserDetails;

@Component
public class Securitybeans {
    
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetails();               // Use MongoUserDetailsService
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();}

}
