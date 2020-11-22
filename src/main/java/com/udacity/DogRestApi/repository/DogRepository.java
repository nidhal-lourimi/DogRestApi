package com.udacity.DogRestApi.repository;

import com.udacity.DogRestApi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

        @Query("select d.id,d.breed from  Dog d where d.id=:id")
        String findBreedById(long id);
        @Query("select  d.id,d.breed from Dog d ")
        List<String> findByAllBreed();
        @Query("SELECT d.id,d.name from Dog d ")
        List<String> findAllName();
    }

