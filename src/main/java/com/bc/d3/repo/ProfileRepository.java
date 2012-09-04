package com.bc.d3.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bc.d3.data.Profile;

public interface ProfileRepository extends MongoRepository<Profile, String> {

}
