package com.example.kasnisi.service.impl;

import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.ShoppingCart;
import com.example.kasnisi.model.ShoppingCartStatus;
import com.example.kasnisi.model.User;
import com.example.kasnisi.model.exceptions.ProductAlreadyInShoppingCartException;
import com.example.kasnisi.model.exceptions.ShoppingCartNotFoundException;
import com.example.kasnisi.model.exceptions.UsernameAlreadyExistsException;
import com.example.kasnisi.model.exceptions.menuEntryNotFound;
import com.example.kasnisi.repository.MenuEntryRepository;
import com.example.kasnisi.repository.ShoppingCartRepository;
import com.example.kasnisi.repository.UserRepository;
import com.example.kasnisi.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final MenuEntryRepository menuEntryRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,UserRepository userRepository,MenuEntryRepository menuEntryRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository=userRepository;
        this.menuEntryRepository=menuEntryRepository;
    }

    @Override
    public List<MenuEntry> listAllProductsInShoppingCart(Long cartId) {
        if(!this.shoppingCartRepository.findById(cartId).isPresent())
            throw new ShoppingCartNotFoundException(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getMenuEntries();
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
    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        MenuEntry product = this.menuEntryRepository.findById(productId)
                .orElseThrow(() -> new menuEntryNotFound(productId));
        if(shoppingCart.getMenuEntries()
                .stream().filter(i -> i.getId().equals(productId))
                .collect(Collectors.toList()).size() > 0)
            throw new ProductAlreadyInShoppingCartException(productId, username);
        shoppingCart.getMenuEntries().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }

}
