package com.udacity.DogRestApi.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogNotFound extends RuntimeException implements GraphQLError {
    public Map<String,Object> extensions =new HashMap<>();
            public DogNotFound(String message ,Long  invalidDogId){
        super(message);
        extensions.put(message,invalidDogId);
            }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
