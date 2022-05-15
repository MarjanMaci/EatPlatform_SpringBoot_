package com.example.kasnisi.web.Rest;

import com.example.kasnisi.model.*;
import com.example.kasnisi.model.dto.CartItemDTO;
import com.example.kasnisi.model.dto.OrderDTO;
import com.example.kasnisi.service.OrderService;
import com.example.kasnisi.service.ShoppingCartService;
import com.example.kasnisi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/cart")
public class ShoppingCartRestController {
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;
    private final UserService userService;

    public ShoppingCartRestController(ShoppingCartService shoppingCartService,
                                      OrderService orderService,
                                      UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.orderService=orderService;
        this.userService=userService;
    }

    @GetMapping("/{cartId}")
    public List<CartItem> findCartItems(@PathVariable String cartId){
        if(this.shoppingCartService.listAllProductsInShoppingCart(Long.parseLong(cartId))!=null){
            return this.shoppingCartService.listAllProductsInShoppingCart(Long.parseLong(cartId));
        }else{
            return null;
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ShoppingCart> addToCart(@RequestBody CartItemDTO cartItemDTO) {
        ShoppingCart shoppingCartItems= this.shoppingCartService.addProductToShoppingCartDTO(cartItemDTO);
        if(shoppingCartItems!=null){
            return ResponseEntity.ok().body(shoppingCartItems);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/order")
    public ResponseEntity<Orders> orderIt(@RequestBody OrderDTO orderDTO) {
        User user = userService.findByEmail(orderDTO.getEmailUser());
        Orders orders= this.orderService.makeAnOrder(
                new Date(),
                orderDTO.getDiscountCode(),
                Long.parseLong(orderDTO.getOrderTotal()),
                orderDTO.getCartItems(),
                user);
        if(orders!=null){
            shoppingCartService.deleteAllProductsInCart(user);
            return ResponseEntity.ok().body(orders);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public List<Orders> findOrders(@RequestParam(value="userEmail") String userEmail){
        User user = userService.findByEmail(userEmail);
        if(this.orderService.listAllOrders(user)!=null){
            return this.orderService.listAllOrders(user);
        }else{
            return null;
        }
    }

    @GetMapping("/allOrders")
    public List<Orders> listAllOrders(){
        if(this.orderService.allOrders()!=null){
            return this.orderService.allOrders();
        }else{
            return null;
        }
    }

    @GetMapping("/change/{id}")
    public void changeStatus(@PathVariable String id){
        this.orderService.changeStatus(Long.parseLong(id));
    }
}
