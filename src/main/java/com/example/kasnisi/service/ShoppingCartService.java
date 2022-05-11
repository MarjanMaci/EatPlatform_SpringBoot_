package com.example.kasnisi.service;

import com.example.kasnisi.model.CartItem;
import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.ShoppingCart;
import com.example.kasnisi.model.dto.CartItemDTO;

import java.util.List;

public interface ShoppingCartService {

    List<CartItem> listAllProductsInShoppingCart(Long cartId);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addProductToShoppingCartDTO(CartItemDTO cartItemDTO);
}
