package com.workout.befit.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "workoutsession")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WorkSession {
    @Id
    private String id;
    private Exercise exercise;
    private List<SetDetails> setDetails;
    
}
