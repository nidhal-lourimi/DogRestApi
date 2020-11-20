package com.udacity.DogRestApi.service;

import com.udacity.DogRestApi.entity.Dog;
import com.udacity.DogRestApi.repository.DogRepository;
import com.udacity.DogRestApi.resolver.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRepository;


    public List<Dog> retrievedogs() {
        return (List<Dog>) dogRepository.findAll();
    }



}
