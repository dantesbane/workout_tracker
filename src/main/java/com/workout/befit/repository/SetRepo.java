package com.workout.befit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workout.befit.models.SetDetails;

public interface SetRepo extends MongoRepository<SetDetails, String> {

}
