package com.workout.befit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workout.befit.models.Exercise;

@Repository
public interface ExerciseRepo extends MongoRepository<Exercise, String> {

}
