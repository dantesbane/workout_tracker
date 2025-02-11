package com.workout.befit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workout.befit.models.Exercise;

public interface ExerciseRepo extends MongoRepository<Exercise, String> {

}
