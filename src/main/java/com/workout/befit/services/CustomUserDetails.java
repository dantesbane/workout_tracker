package com.workout.befit.services;


import java.util.function.Supplier;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.workout.befit.models.User;
import com.workout.befit.repository.UserRepo;



@Service("customuserdetails")
public class CustomUserDetails implements UserDetailsService {
    @Autowired
    private UserRepo userrepo;

    @Autowired
    private PasswordEncoder bcrypt;

    @SuppressWarnings("null")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
        Supplier<UsernameNotFoundException> s= () -> new UsernameNotFoundException("Error find the user");
        
        User user=userrepo.findByUsername(username).orElseThrow(s);
        return user;
    }

    
}
