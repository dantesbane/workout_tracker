package com.workout.befit.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.workout.befit.services.CustomUserDetails;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    CustomUserDetails customuserdetails;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterchain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests((authorize)->authorize.requestMatchers("/signup*","/about").permitAll() //allow requests to signup page
        .anyRequest().authenticated()) //authenticate all other requests
        .csrf(csrf->csrf.disable())    //
        .httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return customuserdetails;  // Use MongoUserDetailsService
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();}
}