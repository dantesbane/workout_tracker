package com.workout.befit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.workout.befit.models.User;
import com.workout.befit.repository.UserRepo;

@Service
@Primary
public class CustomUserDetails implements UserDetailsService {

    @Autowired
    UserRepo userrepo;
    @Autowired
    PasswordEncoder bcrypt;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
        Optional<User> optionaluser=userrepo.findByUsername(username);
        User user=optionaluser.orElseThrow();
        UserBuilder builder = null;
        builder.username(user.getUsername());
        builder.password(bcrypt.encode(user.getPassword()));
        builder.authorities(user.getAuthorities());
        return builder.build();
    }

    
}
