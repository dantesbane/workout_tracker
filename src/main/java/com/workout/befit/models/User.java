package com.workout.befit.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class User {
    @Id
    private String id;
    
    private String username;
    private String password;
    //need to allow each user to have multiple workout routines
    private List<WorkoutRoutine> workoutRoutines;
    
}
