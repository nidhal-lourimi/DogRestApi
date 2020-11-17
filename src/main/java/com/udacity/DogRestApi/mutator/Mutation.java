package com.udacity.DogRestApi.mutator;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.DogRestApi.entity.Dog;
import com.udacity.DogRestApi.exception.BreedNotFound;
import com.udacity.DogRestApi.exception.DogNotFound;
import com.udacity.DogRestApi.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    DogRepository dogRepository;
    public  Mutation (DogRepository dogRepository){this.dogRepository=dogRepository;}

    public boolean deleteDogBreed(String breed){
        boolean deleted=false;
        Iterable<Dog> list= dogRepository.findAll();
        for (Dog dog:list) {
            if (dog.getBreed().equals(breed)) {
                dogRepository.delete(dog);
                 deleted=true;
            }
        }
        if (!deleted){
            throw new BreedNotFound("breed bot found :", breed);
        }

      return deleted;
    }


    public Dog updateDogName(String newName ,Long id){
        Optional<Dog> dogOptional=dogRepository.findById(id);
                if (dogOptional.isPresent()){
                Dog dog=dogOptional.get();
                dog.setName(newName);
                dogRepository.save(dog);
                return dog;
                }
                else {
                    throw new DogNotFound("dog not found",id);
                }
    }


}
