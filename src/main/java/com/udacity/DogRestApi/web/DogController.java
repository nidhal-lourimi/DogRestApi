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

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getAllName() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> list= dogService.retrievedogs();
        return new  ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }
    @GetMapping("/dogs/breed")
    public  ResponseEntity<List<String>> getAllbreeds(){
        return new ResponseEntity<List<String>>(dogService.retrieveDogBreed(),HttpStatus.OK);
    }


    @GetMapping("/dogs/breed/{id}")
    public ResponseEntity<String> getBreedById(@PathVariable Long id){
        String strings= dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(strings,HttpStatus.OK);

    }
}

















