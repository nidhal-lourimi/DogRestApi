package com.udacity.DogRestApi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.DogRestApi.entity.Dog;
import com.udacity.DogRestApi.exception.DogNotFound;
import com.udacity.DogRestApi.repository.DogRepository;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
      private DogRepository dogRepository;
     public  Query(DogRepository dogRepository){this.dogRepository=dogRepository;}


     public Iterable<Dog>  findAllDogs(){
         return   dogRepository.findAll();
     }

     public  String findBreedById(Long id){
         Optional <Dog> list =dogRepository.findById(id);
         if (list.isPresent()){
             return list.get().getBreed();
         }
         else {
             throw new DogNotFound("dog not found ",id);
         }
     }
}
