package com.udacity.DogRestApi.web;


import com.udacity.DogRestApi.entity.Dog;
import com.udacity.DogRestApi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    private DogService dogService;
    @Autowired
    public void setServiceDog(DogService dogService){
        this.dogService = dogService;
    }



    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
       List<Dog> list= dogService.retrievedogs();
       return new  ResponseEntity (list, HttpStatus.OK);
    }

}




















