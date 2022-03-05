package com.example.kasnisi.model.exceptions;

public class menuEntryNotFound extends RuntimeException{
    public menuEntryNotFound(Long menuEntryId){super(String.format("%s is not found in our database.",menuEntryId.toString()));}

}
