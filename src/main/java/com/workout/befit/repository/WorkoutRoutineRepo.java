package com.workout.befit.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.workout.befit.models.WorkoutRoutine;

public interface WorkoutRoutineRepo extends MongoRepository <WorkoutRoutine,String> {

}
