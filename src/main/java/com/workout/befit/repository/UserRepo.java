package com.workout.befit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workout.befit.models.User;
import java.util.Optional;


public interface UserRepo extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
