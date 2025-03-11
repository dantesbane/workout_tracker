package com.workout.befit.controller;

import org.springframework.web.bind.annotation.RestController;

import com.workout.befit.repository.UserRepo;
import com.workout.befit.services.AuthServices;
import com.workout.befit.utils.Signuprequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.workout.befit.models.User;



@RestController
public class AuthController {

    @Autowired
    AuthServices authservices;

    @PostMapping("/signup")
    public ResponseEntity<String> Usersignup(@RequestBody @Validated Signuprequest entity) throws Exception {

        ResponseEntity<String> response=authservices.signupservice(entity);

        return response;
    }
    
    @GetMapping("/about")
    public ResponseEntity<String> getabout() {
        return new ResponseEntity<String>("The request is being allowed", HttpStatus.OK);
    }

    @GetMapping("/checklogin")
    public ResponseEntity<List<String>> checklogiinandgetuserlist(){
        
        ResponseEntity<List<String>> response=authservices.getListofUsers();
        return response;

    }

/*     @GetMapping("/checkallusers")
    public ResponseEntity<String> getallusers(){
        
    }
     */

}
