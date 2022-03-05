package com.example.kasnisi.model.exceptions;

public class ShoppingCartNotFoundException extends RuntimeException{
    public ShoppingCartNotFoundException(Long cartId){super(String.format("%s is not found in our database.",cartId.toString()));}
}
