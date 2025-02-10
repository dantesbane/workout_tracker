package com.workout.befit.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String id;
    private String username;
    private String password;
    //need to allow each user to have multiple workout routines
    private List<WorkoutRoutine> workoutRoutines;
    
}
