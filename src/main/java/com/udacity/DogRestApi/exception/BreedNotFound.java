package com.udacity.DogRestApi.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreedNotFound extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public BreedNotFound(String message, String invalidBreed) {
        super(message);
        extensions.put(message, invalidBreed);
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
