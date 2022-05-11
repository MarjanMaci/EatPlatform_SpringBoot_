package com.example.kasnisi.web.Rest;

import com.example.kasnisi.model.Restaurants;
import com.example.kasnisi.model.User;
import com.example.kasnisi.service.RestaurantService;
import com.example.kasnisi.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/home")
public class HomeRestController {
    private final RestaurantService restaurantService;
    private final UserService userService;

    public HomeRestController(RestaurantService restaurantService, UserService userService) {
        this.restaurantService = restaurantService;
        this.userService = userService;
    }

    @GetMapping
    public List<Restaurants> getAll(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{username}")
    public User findByUsername(@PathVariable String username){
        return userService.loadUserByUsername(username);
    }
}
