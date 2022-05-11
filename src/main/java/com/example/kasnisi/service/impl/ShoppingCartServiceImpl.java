package com.example.kasnisi.service.impl;

import com.example.kasnisi.model.*;
import com.example.kasnisi.model.dto.CartItemDTO;
import com.example.kasnisi.model.exceptions.ShoppingCartNotFoundException;
import com.example.kasnisi.model.exceptions.UsernameAlreadyExistsException;
import com.example.kasnisi.model.exceptions.menuEntryNotFound;
import com.example.kasnisi.repository.CartItemRepository;
import com.example.kasnisi.repository.MenuEntryRepository;
import com.example.kasnisi.repository.ShoppingCartRepository;
import com.example.kasnisi.repository.UserRepository;
import com.example.kasnisi.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final MenuEntryRepository menuEntryRepository;
    private final CartItemRepository cartItemRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, MenuEntryRepository menuEntryRepository, CartItemRepository cartItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository=userRepository;
        this.menuEntryRepository=menuEntryRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public List<CartItem> listAllProductsInShoppingCart(Long cartId) {
        if(!this.shoppingCartRepository.findById(cartId).isPresent())
            throw new ShoppingCartNotFoundException(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getCartItems();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameAlreadyExistsException(username));

        return this.shoppingCartRepository
                .findByUserAndStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });

    }

    @Override
    public ShoppingCart addProductToShoppingCartDTO(CartItemDTO cartItemDTO) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(cartItemDTO.getUsername());
        MenuEntry product = this.menuEntryRepository.findById(cartItemDTO.getMealId())
                .orElseThrow(() -> new menuEntryNotFound(cartItemDTO.getMealId()));
        CartItem item = new CartItem(product,cartItemDTO.getAmmount());
        this.cartItemRepository.save(item);
        shoppingCart.getCartItems().add(item);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
