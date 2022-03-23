package com.example.kasnisi.service;

import com.example.kasnisi.model.CartItem;
import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<CartItem> listAllProductsInShoppingCart(Long cartId);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addProductToShoppingCart(String username, Long productId);
}
