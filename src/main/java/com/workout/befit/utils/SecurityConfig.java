package com.workout.befit.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.workout.befit.services.CustomUserDetails;


@Configuration
@EnableWebSecurity
@ComponentScan
public class SecurityConfig {
    @Autowired
    CustomUserDetails customuserdetails;

    

    @Bean
    public SecurityFilterChain securityFilterchain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests((authorize)->authorize.requestMatchers("/signup*","/about").permitAll() //allow requests to signup page
        .anyRequest().authenticated()) //authenticate all other requests
        .httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults());
        return http.build();
    }


}