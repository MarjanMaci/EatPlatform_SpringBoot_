package com.example.kasnisi.model.exceptions;

public class ProductAlreadyInShoppingCartException extends RuntimeException{
    public ProductAlreadyInShoppingCartException(Long productId,String username){super(String.format("Product with id= %s is already in %s shopping cart.",productId.toString(), username ));}
}
