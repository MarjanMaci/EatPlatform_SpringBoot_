package com.example.kasnisi.service;

import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<MenuEntry> listAllProductsInShoppingCart(Long cartId);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addProductToShoppingCart(String username, Long productId);
}
