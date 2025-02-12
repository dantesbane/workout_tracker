package com.workout.befit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workout.befit.models.ExerciseSession;

public interface WorkSessionRepo extends MongoRepository<ExerciseSession,String> {

}
