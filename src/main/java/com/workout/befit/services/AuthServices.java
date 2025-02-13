package com.workout.befit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.workout.befit.models.User;
import com.workout.befit.repository.UserRepo;
import com.workout.befit.utils.Signuprequest;

@Service
public class AuthServices {
    @Autowired
    private UserRepo userrepo;
    @Autowired 
    BCryptPasswordEncoder passwordencoder;
    public ResponseEntity<String> signupservice(Signuprequest entity){
        String username=entity.getUsername();
        String password=entity.getPassword();

        userrepo.findByUsername(username).ifPresent(user -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Username already taken");
        }); //check if username is duplicate
        
        String hashedpassword=passwordencoder.encode(password);
        User user=new User(username,hashedpassword);
        userrepo.save(user);
        return new ResponseEntity<String>("Signup complete",HttpStatus.ACCEPTED);
    }

    
}
