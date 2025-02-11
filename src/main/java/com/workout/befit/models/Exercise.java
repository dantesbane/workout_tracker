package com.workout.befit.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

// I think only a name should be good enough for an exercise
@Document(collection = "exercises")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Exercise {
    @Id
    
    private String id;

    private String exercisename;
    // I want to track set details here 
    // Need to be able to make new sets for an exercise for each routine
    // Making a session model might make it easier
    
}
