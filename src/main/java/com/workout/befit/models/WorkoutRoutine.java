package com.workout.befit.models;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "workoutroutines")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkoutRoutine {

    @Id
    private String id;

    private String routinename;
    private List<WorkSession> workSessions;
    
    //i also want to track the weight of used and the number of reps
    //i think i should also track the number of sets for each exercise
}
