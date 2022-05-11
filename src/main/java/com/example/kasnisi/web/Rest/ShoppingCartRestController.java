package com.example.kasnisi.web.Rest;

import com.example.kasnisi.model.CartItem;
import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.Restaurants;
import com.example.kasnisi.model.ShoppingCart;
import com.example.kasnisi.model.dto.CartItemDTO;
import com.example.kasnisi.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/cart")
public class ShoppingCartRestController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartRestController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<CartItem> findCartItems(){
        if(this.shoppingCartService.listAllProductsInShoppingCart(Long.parseLong("2"))!=null){
            return this.shoppingCartService.listAllProductsInShoppingCart(Long.parseLong("2"));
        }else{
            return null;
        }
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ShoppingCart> addToCart(@RequestBody CartItemDTO cartItemDTO) {
        ShoppingCart shoppingCartItems= this.shoppingCartService.addProductToShoppingCartDTO(cartItemDTO);
        if(shoppingCartItems!=null){
            return ResponseEntity.ok().body(shoppingCartItems);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
