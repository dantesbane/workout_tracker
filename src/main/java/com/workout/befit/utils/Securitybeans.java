package com.workout.befit.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.workout.befit.services.CustomUserDetails;

@Configuration
public class Securitybeans {
    @Bean
    public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();}

    @Bean
    public UserDetailsService customuserdetailsservice(){
        return new CustomUserDetails();
    }

    @Bean
    public AuthenticationProvider authprovider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(customuserdetailsservice());
        return provider;
    }
    
}
