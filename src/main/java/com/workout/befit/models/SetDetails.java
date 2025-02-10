package com.workout.befit.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "setdetails")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SetDetails {
    @Id
    private String id;

    private Integer weight;
    private Integer reps;
}
