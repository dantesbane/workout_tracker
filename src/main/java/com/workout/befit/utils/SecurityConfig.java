package com.workout.befit.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.workout.befit.services.CustomUserDetails;


@Configuration
@EnableWebSecurity
@ComponentScan
public class SecurityConfig {
    @Autowired
    @Qualifier("customuserdetails")
    CustomUserDetails customuserdetails;

    @Autowired
    PasswordEncoder passencoder;

    @Autowired
    AuthenticationProvider authprovider;
    

    @Bean
    public SecurityFilterChain securityFilterchain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests(authorize->authorize.requestMatchers("/signup","/about","/error/**").permitAll() //allow requests to signup page
        .anyRequest().authenticated()) //authenticate all other requests
        .httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults())
        .csrf(csrf-> csrf.disable());
        return http.build();
    }

    
 

}