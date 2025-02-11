package com.workout.befit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workout.befit.models.User;

public interface UserRepo extends MongoRepository<User, String> {

}
