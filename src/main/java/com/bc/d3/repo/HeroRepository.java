package com.bc.d3.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bc.d3.data.Hero;

public interface HeroRepository extends MongoRepository<Hero, Long> {

}
