package com.workout.befit.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ExerciseController {
    @GetMapping("/")
    public ResponseEntity<String> exercisename() {
        return new ResponseEntity<>("Hello",HttpStatus.ACCEPTED);
    }
    

}
