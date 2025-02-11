package com.workout.befit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workout.befit.models.WorkSession;

public interface WorkSessionRepo extends MongoRepository<WorkSession,String> {

}
