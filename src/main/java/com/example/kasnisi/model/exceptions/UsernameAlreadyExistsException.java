package com.example.kasnisi.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String username){super(String.format("%s is already in our database.",username));}
}
