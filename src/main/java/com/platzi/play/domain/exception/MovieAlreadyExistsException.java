package com.platzi.play.domain.exception;

public class MovieAlreadyExistsException extends RuntimeException {

    public MovieAlreadyExistsException(String title) {
        super("movie with title '" + title + "' already exists");
    }
}
