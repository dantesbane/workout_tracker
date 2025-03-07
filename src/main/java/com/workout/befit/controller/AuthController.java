package com.workout.befit.controller;

import org.springframework.web.bind.annotation.RestController;

import com.workout.befit.repository.UserRepo;
import com.workout.befit.services.AuthServices;
import com.workout.befit.utils.Signuprequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class AuthController {
    @Autowired
    PasswordEncoder passencoder;

    @Autowired
    UserRepo userrepo;
    @Autowired
    AuthServices authservices;

    @PostMapping("/signup")
    public ResponseEntity<String> Usersignup(@RequestBody @Validated Signuprequest entity) {

        ResponseEntity<String> response=authservices.signupservice(entity);

        return response;
    }
    
    @GetMapping("/about")
    public ResponseEntity<String> getMethodName() {
        return new ResponseEntity<String>("The request is being allowed", HttpStatus.I_AM_A_TEAPOT);
    }
    

}
