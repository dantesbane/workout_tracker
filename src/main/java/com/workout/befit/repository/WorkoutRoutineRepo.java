package com.workout.befit.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workout.befit.models.WorkoutRoutine;

@Repository
public interface WorkoutRoutineRepo extends MongoRepository <WorkoutRoutine,String> {

}
