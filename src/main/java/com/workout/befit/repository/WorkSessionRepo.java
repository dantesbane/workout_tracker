package com.workout.befit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workout.befit.models.ExerciseSession;


@Repository
public interface WorkSessionRepo extends MongoRepository<ExerciseSession,String> {

}
