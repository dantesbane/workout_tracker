package com.workout.befit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workout.befit.models.SetDetails;

@Repository
public interface SetRepo extends MongoRepository<SetDetails, String> {

}
