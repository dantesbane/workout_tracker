package com.workout.befit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.workout.befit.models.User;
import com.workout.befit.repository.UserRepo;

@Service
@Primary
public class CustomUserDetails implements UserDetailsService {
    
    
    @Autowired
    private UserRepo userrepo;

@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user from the database
        User user = userrepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Convert the User object to a Spring Security UserDetails object
        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
        builder.password(user.getPassword());
        builder.authorities(user.getAuthorities());
        
        return builder.build();
    }
}
