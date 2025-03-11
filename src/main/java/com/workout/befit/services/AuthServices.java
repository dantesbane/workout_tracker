package com.workout.befit.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.workout.befit.models.User;
import com.workout.befit.repository.UserRepo;
import com.workout.befit.utils.Signuprequest;

@Service
@ComponentScan
public class AuthServices {
    @Autowired
    private UserRepo userrepo;

    @Autowired 
    PasswordEncoder passwordencoder;

    public ResponseEntity<String> signupservice(Signuprequest entity) throws Exception{
        String username=entity.getUsername();
        String password=entity.getPassword();
              
        userrepo.findByUsername(username).ifPresent(user -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Username already taken");
        });
         //check if username is duplicate
        
        String hashedpassword=passwordencoder.encode(password);
        User user=new User(username,hashedpassword);
        User saveduser=userrepo.save(user);
        return new ResponseEntity<String>("Signup complete with username" + saveduser.getUsername(),HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<String>> getListofUsers(){
        List<User> userlist=userrepo.findAll();
        List<String> userstringlist=new ArrayList<>();
        
        for (int i=0;i<userlist.size();i++){
            userstringlist.add(userlist.get(i).toString());
        }
        return new ResponseEntity<List<String>>(userstringlist,HttpStatus.ACCEPTED); 
    }
    
}
