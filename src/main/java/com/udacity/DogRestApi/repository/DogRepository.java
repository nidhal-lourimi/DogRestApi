package com.udacity.DogRestApi.repository;

import com.udacity.DogRestApi.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}